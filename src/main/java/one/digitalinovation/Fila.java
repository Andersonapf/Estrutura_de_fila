package one.digitalinovation;

public class Fila<T> {

    private No<T> refNoEntradaFila;  // referencia de entrada da fila | entrando pelo final da fila.

    public Fila() {
        this.refNoEntradaFila = null;    // estanciando a fila vazia
    }

    public void enqueue(T object){         // enfileirar
        No novoNo = new No(object);
        novoNo.setRefNo(refNoEntradaFila);  // novo nó entrou na fila
        refNoEntradaFila = novoNo;          // a refereincia era que o novo nó era o antigo ultimo nó.
    }

    public T first(){                   // retorna o primeiro nó da fila
        if(!this.isEmpty()){             // testando se a fila não está vazia ! == negação
            No primeiroNo = refNoEntradaFila;
            while(true){       // caso não teja só um nó na fila loop para chegar no primeiro da fila.
                if(primeiroNo.getRefNo() != null){   // se não for o primeiro faça
                    primeiroNo = primeiroNo.getRefNo();   // primeiroNo passa a ser o nó na frente dele.
                }else{
                    break;
                }

            }
            return (T) primeiroNo.getObject();

        }
        return null;       // caso esteja vazia retorne null;
    }

    public T dequeue(){     // retira o primeiro nó
        if(!this.isEmpty()){
            No primeiroNo = refNoEntradaFila;
            No noAuxiliar = refNoEntradaFila;
            while(true){
                if(primeiroNo.getRefNo() != null){
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                }else{
                    noAuxiliar.setRefNo(null);
                    break;
                }

            }
            return (T) primeiroNo.getObject();

        }
        return null;
    }

    public boolean isEmpty(){             //testando se a fila está vazia
        return refNoEntradaFila == null? true : false;      //
    }

    @Override
    public String toString() {
        String stringRetorno = "";
        No noAuxiliar = refNoEntradaFila;

        if(refNoEntradaFila != null){
            while (true){
                stringRetorno += "[No{object: " + noAuxiliar.getObject() + "}]--->";
               // noAuxiliar = noAuxiliar.getRefNo();
                if(noAuxiliar.getRefNo() != null){
                    noAuxiliar = noAuxiliar.getRefNo();
                }else{
                    stringRetorno += "null";
                    break;
                }
            }
        }else{
            stringRetorno = "null";
        }

        return  stringRetorno;
    }
}
