package org.example;

public class User {

    private String password;

    public void initPassword(PasswordGenerator passwordGenerator){
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
        String pasword = passwordGenerator.generatePassword();
        
        /*
        * 비밀번호는 최소 8자 이상 12자 이하여야 한다
        * */

        if(pasword.length() >=8 && pasword.length() <= 12){
            this.password = pasword;
        }
    }


    public String getPassword(){
        return  password;
    }

}
