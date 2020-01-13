package timbuchalka.GenericsDemo.BasicGenerics;

public class Test<T> {
	T obj;

	Test(T obj) {
		this.obj = obj;
	}

	public T getObject() {
		return this.obj;
	}
	
	public void setObject(T obj) {
		this.obj=obj;
	}
}

