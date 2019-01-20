import java.util.ArrayList;

public class RevArrayList<E> extends ArrayList<E>{

    public RevArrayList(int max){
        super(max);
    }

    public E get(int index){
        index = index % size();

        return super.get(index);
    }
}
