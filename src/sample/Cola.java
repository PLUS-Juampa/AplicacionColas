package sample;

/**
 * Created by juam_ on 22/11/2017.
 */
public class Cola {
    {
        //Metodo ver el tamaño
    }
        private Nodo frente;
        private int tamaño;
    public boolean vacia(){return frente==null;}
    public int getTamaño(){ return tamaño;}

    public Cola() {
        frente= null;
        tamaño = 0;
    }


    public void insertar(int valor){
        Nodo nuevo = new Nodo(valor);
        if(frente == null){
            frente = nuevo;
        }else {
            Nodo temp = frente;
            while (temp.getProximo() != null){
                temp = temp.getProximo();
            }
            temp.setProximo(nuevo);
        }
        size++;
    }

    public void mostrar(){
        if(frente != null){
            Nodo temp = frente;
            System.out.println("Los valores de la cola son: ");
            while (temp != null){
                System.out.println(temp.getValor());
                temp = temp.getProximo();
            }
            System.out.println();
        }else {
            System.out.println("\n\tLa cola está vacía.\n");
        }
    }

    //Metodo para vaciar
    public String vaciarLista(){
        if(!vacia()){
            frente=null;
            tamaño=0;
            return "La cola ah sido vaciada";
        }else{

            return "La cola no tiene valores";
        }
    }


    public int getSize(){
        return size;
    }

    public int extraer(){
        if(frente == null){
            return 0;
        }
        else {
            int valorExtraer = frente.getValor();
            frente  = frente.getProximo();
            System.out.println("Valor extraiído:  " + valorExtraer);
            size--;
            return valorExtraer;
        }
    }

}
