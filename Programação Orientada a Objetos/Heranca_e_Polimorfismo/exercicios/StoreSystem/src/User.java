public sealed abstract class User permits Manager, Seller, Attendant{
    protected String name;
    protected String email;
    protected String password;
    protected boolean isAdmin;

    protected boolean isLogged;

    public boolean isAdmin(){
        return this.isAdmin;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login(String email, String senha){
        if (this.getEmail().equals(email) && this.getPassword().equals(senha)){
            isLogged = true;
            return "Login Realizado";
        }
        return "Erro. Email ou Senha Incorretos";
    }

    public String logoff(){
        if (isLogged){ //true
            isLogged = false;
            return "Realizando Logoff";
        } return "Você não está Logado no sistema";
    }

    public void chanceData(String name, String email, boolean admin){
        this.name = name;
        this.email = email;
        this.isAdmin = admin;
        System.out.println("Dados alterados");
    }

    public void chancePassword(String currentPassword, String newPassword){
        if (this.password.equals(currentPassword)){
            this.password = newPassword;
            System.out.println("Senha alterada");
        } else System.out.println("A senha atual está incorreta");
    }

    public abstract  String consultSales();
}
