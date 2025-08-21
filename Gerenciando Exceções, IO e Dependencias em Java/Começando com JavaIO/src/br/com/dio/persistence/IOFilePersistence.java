package br.com.dio.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Stream;

public class IOFilePersistence implements FilePersistence{
    private final String currentDir = System.getProperty("user.dir"); //retorna o diretorio
    private final String storedDir = "/managedFiles/IO/";
    private final String fileName;

    public IOFilePersistence(String fileName) throws IOException{
        this.fileName = fileName;
        var file = new File(currentDir + storedDir);
        if (!file.exists() && !file.mkdirs()) throw new IOException("Erro ao criar arquivo"); //mkdir retorna true se conseguir criar o diretorio e false se não

        clearFile();
    }

    @Override
    public String findAll() {
        var content = new StringBuilder();
        try(var reader = new BufferedReader(new FileReader(currentDir + storedDir + fileName))){
            //abre o arquivo em modo leitura, o Buffered permite ler linha por linha
            String line;
            do {
                line = reader.readLine();
                if ((line != null)) content.append(line).append(System.lineSeparator()); //adicionar cada linha ao StringBuilder junto com a quebra de linha
            } while (line != null);
        } catch (IOException e){
            e.printStackTrace();
        }
        return content.toString();
    }

    @Override
    public String findBy(String sentence) {
        var found = "";
        try (var reader = new BufferedReader(new FileReader(currentDir + storedDir + fileName))){
            String line = reader.readLine();
            while (line != null){
                if (line.contains(sentence)){
                    found = line;
                    break;
                }
                line = reader.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return found;
    }

    @Override
    public boolean remove(String sentence) {
        var contentList = toListString();

        if (contentList.stream().noneMatch(c -> c.contains(sentence))) return false; //noneMatch verifica linha por linha se tem a sentence a ser removida
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
        try(
            var fileWriter = new FileWriter(currentDir + storedDir + fileName, true);
            var bufferedWriter = new BufferedWriter(fileWriter); //vai trabalhar escrevedo o arquivo
            var printWriter = new PrintWriter(bufferedWriter);
        ){
            printWriter.println(data);
        } catch(IOException ex){
            ex.printStackTrace();
        }
        return data;
    }

    private void clearFile(){ //*Por padrão, FileOutputStream apaga todo o conteúdo antes de abrir o arquivo
        try(OutputStream outputStream = new FileOutputStream(currentDir + storedDir + fileName)){ 
            System.out.printf("Inicializando recursos (%s)\n", currentDir + storedDir + fileName);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    } //nesse exemplo a execução está entre () no try para q a classe seja fechada automaticamente (sem finally)

    private ArrayList<String> toListString() {
        var content = findAll();
        return new ArrayList<>(Stream.of(content.split(System.lineSeparator())).toList());
    }
}   
