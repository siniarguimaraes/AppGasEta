package devandroid.ssg.appgaseta.apoio;

public class UtilGasEta {

    public void MetodoEstatico(){

    }

    public static void MetodoNaoEstatico(){

    }

    public static String mensagem(){
        return "Qualquer Mensagem...";
    }

    public static double valorRetorno(){
        return 9.99;
    }

    public static String calcularMelhorOpcao(double gasolina, double etanol){

        double precoIdeal = gasolina * 0.70;
        String mensagemDeRetorno;
        if(etanol <= precoIdeal){
            mensagemDeRetorno = "Abasteça com Etanol";
        }else{
            mensagemDeRetorno = "Abasteça com Gasolina";
        }

        return mensagemDeRetorno;
    }
}
