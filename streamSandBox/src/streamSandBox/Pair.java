package streamSandBox;

import java.util.Objects;

public class Pair<T, U> {
	final public T first;
	final public U second;

	public Pair(T t, U u){
		first = t;
		second = u;
	}

	@Override
	public boolean equals(Object o1){
		if (o1 instanceof Pair) {
            Pair p = (Pair)o1;
            return Objects.equals(first,p.first) && Objects.equals(second,p.second);
        }
        return false;
	}
	
	@Override public int hashCode() {
        int hash = 1;
        hash = hash * 31 + first.hashCode();
        hash = hash * 31 + second.hashCode();
        return hash;
    }
    @Override public String toString(){
        return "(" + first + "," + second +")";
    }
}
