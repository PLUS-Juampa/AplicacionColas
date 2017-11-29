package sample;

public class Cola {
    int posicion = 0;   // Variable para mostrar posición de número
    private Nodo frente;    // Intancia de clase Nodo
    private int tamaño; // Variable para control de tamaño

    public boolean vacia(){
        return (frente == null); //regresa si esta vacía o no
    }

    public int getTamaño(){ return tamaño;} // Método para devolver tamaño

    public Cola() { // Constructor de clase Cola
        frente= null;   // Elemento frente en nulo
        tamaño = 0;     // Tamaño en cero
    }

    public void setTamaño(int tam){
        this.tamaño = tam;  // Recibe el tamaño y se incrementa dependiendo las veces invocado el método
    }

    public void insertar(int valor){    // Método para insertar elemento en cola
        Nodo nuevo = new Nodo(valor);   // Instancia nueva de clase Nodo
        if(frente == null){ // Si frente es nulo se toma el valor del parámetro
            frente = nuevo;
        }else { // En caso de que frente no sea nulo
            Nodo temp = frente; // Instancia nueva de clase Nodo para igualar frente a una variable temporal
            while (temp.getProximo() != null){  // Mientras el nuevo nodo temporal no sea nulo
                temp = temp.getProximo();   // El nodo temporal pasa a ser el proximo
            }
            temp.setProximo(nuevo); // Se manda valor nuevo al nodo temporal
        }
        tamaño++;   // Tamaño incrementa en una unidad
    }

    public void mostrar(){  // Método para mostrar los elementos de la cola en consola          *x*
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

    //Metodo para vaciar lista y mandar mensajes en consola
    public String vaciarLista(){
        if(!vacia()){
            frente=null;
            tamaño=0;
            return "La cola ah sido vaciada";
        }else{

            return "La cola no tiene valores";
        }
    }
    //  Método para extraer número de la Cola y que devuelva el valor estraido
    public int extraer(String text){
        if(frente == null){
            return 0;
        }
        else {
            int valorExtraer = frente.getValor();
            frente  = frente.getProximo();
            tamaño--;
            return valorExtraer;
        }
    }
    // Método auxiliar para extraer el valor de la Cola
    public void auxiliar(){
        if(frente == null){
            return;
        }
        else {
            int valorExtraer = frente.getValor();
            frente  = frente.getProximo();
            tamaño--;
            return;
        }
    }

    public String buscar(int buscando){
        String resultado; //    Variable para guardar el resultado de la busqueda
        boolean encontrado =false; // Variable para saber si se encontro el valor
        int valor = buscando;
        int posicion=1; // posición inicail en 1
        if(!vacia()){ // condición para saber si la cola esta vacía
            Nodo temp= frente; //creación de una cola temporal
            while(temp != null){ // ciclo para recorrer los nodos de la cola
                if(valor == temp.getValor()){ //condición para comparar los valores con el valor buscado
                    resultado = "El valor: "+ temp.getValor()+ " se encuentra en la posición : " + posicion + "\n"; // mensaje de encaontrado y la posición
                    encontrado =true; // se cambia la variable a verdadera
                    return resultado; // regresa el mensaje
                }
                temp = temp.getProximo(); //obtine el siguiente valor
                posicion++; //la posicón aumenta
            }
            if(!encontrado){ //si no se encontro devuelve el mensaje
                resultado = "Valor no encontrado en la cola" ;
                return resultado;
            }
        }else { // Sí la cola está vacía regresa el mensaje
            resultado = "La cola está vacía.\n";
            return resultado;
        }
        return "";
    }
}
