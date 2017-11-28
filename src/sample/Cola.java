package sample;

/**
 * Created by juam_ on 22/11/2017.
 */
public class Cola {

    int posicion = 0;

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
        tamaño++;
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


    public int extraer(){
        if(frente == null){
            return 0;
        }
        else {
            int valorExtraer = frente.getValor();
            frente  = frente.getProximo();
            System.out.println("Valor extraiído:  " + valorExtraer);
            tamaño--;
            return valorExtraer;
        }
    }

    public int buscar(int busqueda){
        try {
            Nodo temp = frente;
            if(temp.getValor() == busqueda) {
                return 0;
            }else{
                while(temp != null){
                    if (temp.getProximo().getValor()== busqueda){
                        return posicion++;
                    }
                    temp = temp.getProximo();
                    posicion ++;
                }
            }
            return posicion;
        }finally {
            System.out.println("¡Número o valor no encontrado!");
        }

    }


}
