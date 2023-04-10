public class ValidadorCPF {
    public static boolean ehCpfValido(String cpf) {
        cpf = cpf.replaceAll("[^\\d]", "");

        if (cpf.length() != 11) {
            return false;
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int primeiroDigito = 11 - (soma % 11);
        if (primeiroDigito > 9) {
            primeiroDigito = 0;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int segundoDigito = 11 - (soma % 11);
        if (segundoDigito > 9) {
            segundoDigito = 0;
        }

        if(cpf.charAt(9) == Character.forDigit(primeiroDigito, 10) && cpf.charAt(10) == Character.forDigit(segundoDigito, 10)){
            return true;
        } else{
            return false;
        }
        //return cpf.charAt(9) == Character.forDigit(primeiroDigito, 10) && cpf.charAt(10) == Character.forDigit(segundoDigito, 10);
    }
}