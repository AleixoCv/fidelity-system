public class StringUtil{
    //Run | Debug
    private StringUtil() {}
    public static boolean ehNuloOuBranco(String str){
        if(!str || str.trim()== ""){
            return true;
        }else {
            return false;
        }
    }
}