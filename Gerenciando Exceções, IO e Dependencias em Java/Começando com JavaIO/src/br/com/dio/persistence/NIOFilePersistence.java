package br.com.dio.persistence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.stream.Stream;

public class NIOFilePersistence implements FilePersistence{
    private final String currentDir = System.getProperty("user.dir"); //retorna o diretorio
    private final String storedDir = "/managedFiles/NIO/";
    private final String fileName;

    public NIOFilePersistence(String fileName) throws IOException{
        this.fileName = fileName;
        var file = new File(currentDir + storedDir);
        if (!file.exists() && !file.mkdirs()) throw new IOException("Erro ao criar arquivo"); //mkdir retorna true se conseguir criar o diretorio e false se não

        clearFile();    
    }

    @Override
    public String findAll() {
        var content = new StringBuffer();
        try (
            var file = new RandomAccessFile(new File(currentDir + storedDir + fileName), "r");
            var channel = file.getChannel();
        ){
            var buffer = ByteBuffer.allocate(256); //cria buffer temporario com capacidade 256 bytes para armazenar dados lidos do arquivo antes de processar
            var bytesReader = channel.read(buffer); //o channel lê os dados do arquivo e coloca dentro do buffer.O retorno (bytesReader) é a quantidade de bytes lidos (ou -1 se chegou no fim do arquivo).

            while(bytesReader != -1){ 
                buffer.flip(); //*ajusta os ponteiros de escrita para leitura
                while(buffer.hasRemaining()){ //hasRemaining verifica se ainda tem bytes
                    content.append((char) buffer.get()); //paga o byte do buffer e converte para caractere (armazena no content)
                }
                buffer.clear(); // metodo do buffer para limpar
                bytesReader = channel.read(buffer);
            }
        } catch (Exception ex) {
            ex.printStackTrace();   
        }
        return content.toString();
    }

    @Override
    public String findBy(String sentence) {
        var content = new StringBuffer();
        try (
            var file = new RandomAccessFile(new File(currentDir + storedDir + fileName), "r");
            var channel = file.getChannel();
        ){
            var buffer = ByteBuffer.allocate(256); 
            var bytesReader = channel.read(buffer); //guarda quantos bytes foram lidos (ou -1 se acabou)

            while(bytesReader != -1){ 
                buffer.flip(); //muda o buffer do modo escrita (canal encheu) para modo leitura (seu código consome).
                while(buffer.hasRemaining()){ 
                    while(!content.toString().endsWith(System.lineSeparator())){
                        content.append((char) buffer.get());
                    }
                    if (content.toString().contains(sentence)){
                        break;
                    } else{
                        content.setLength(0);
                    }
                    if (!content.isEmpty()) break; //a linha é redundante?
                }
                buffer.clear();
                bytesReader = channel.read(buffer);
            }
        } catch (Exception ex) {
            ex.printStackTrace();   
        }
        return content.toString();
    }

    @Override
    public boolean remove(String sentence) {
        var contentList = toListString();

        if (contentList.stream().noneMatch(c -> c.contains(sentence))) return false;

        clearFile();
        contentList.stream()
                    .filter(c -> !c.contains(sentence))
                    .forEach(this::write);
        return true;
    }

    @Override
    public String replace(String oldContent, String newContent) {
        var contentList = toListString();

        if (contentList.stream().noneMatch(c -> c.contains(oldContent))) return "";

        clearFile();
        contentList.stream()
                    .map(c -> c.contains(oldContent) ? newContent : c)
                    .forEach(this::write);
        return newContent;
    }

    @Override
    public String write(String data) {
        try (var file = new RandomAccessFile(new File(currentDir + storedDir + fileName), "rw")){
            file.seek(file.length()); //*seek move o cursor (vai mover para o final do arquivo por causa do length)
            file.writeBytes(data); //Escrever a string data no arquivo como byte
            file.writeBytes(System.lineSeparator()); //quebra de linha
        } catch(IOException ex){
            ex.printStackTrace();
        }
        return data;
    }
    
    private void clearFile(){ //*Por padrão, FileOutputStream apaga todo o conteúdo antes de abrir o arquivo
        try(OutputStream outputStream = new FileOutputStream(currentDir + storedDir + fileName)){ 
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private ArrayList<String> toListString() {
        var content = findAll();
        return new ArrayList<>(Stream.of(content.split(System.lineSeparator())).toList());
    }
}
