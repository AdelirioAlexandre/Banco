package Bancogeek.helper;
import java.util.Date;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Utils {

    //Formatação para a linguagem Br
    //Iniciando as importações
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yy");
    static NumberFormat nf = new DecimalFormat("R$ #,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
    
    //Conversão de Date para String
    public static String dateParaString(Date data){
        return Utils.sdf.format(data);
    }
    //Conversão de String para Date
    public static Date StringParaDate(String date){
        try{
            return Utils.sdf.parse(date);
        }catch(ParseException e){
            return null;
        }
    }
    //Conversão de Valor para String
    public static String doubleParaString(Double valor){
        return Utils.nf.format(valor);
    }
    //Conversão de Valor para Double
    public static Double stringParaDouble(String valor){
        try{
            return (Double)Utils.nf.parse(valor);
        }catch(ParseException e){
            return null;
        }
    }   
    
    //Sistema de pausar
    public static void pausar(int segundos){
        try{
            TimeUnit.SECONDS.sleep(segundos);
        }catch(InterruptedException e){
            System.out.println("Erro ao pausar por " +segundos+ " segundos");
        }
    }
}

