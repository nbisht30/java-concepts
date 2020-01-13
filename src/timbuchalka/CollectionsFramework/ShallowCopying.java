package timbuchalka.CollectionsFramework;

//class to demonstrate Shallow Copying
public class ShallowCopying implements Comparable<ShallowCopying> {
	int field1;
	char field2;

	public ShallowCopying(int field1, char field2) {
		this.field1 = field1;
		this.field2 = field2;
	}

	public int getField1() {
		return field1;
	}

	public char getField2() {
		return field2;
	}

	public void setField1(int field1) {
		this.field1 = field1;
	}

	public void setField2(char field2) {
		this.field2 = field2;
	}

	@Override
	public int compareTo(ShallowCopying o) {
		// TODO Auto-generated method stub
		if (this.field1 < o.field2)
			return -1;
		else if (this.field1 > o.field2) {
			return 1;
		} else{
			if(this.field2<o.field2)
				return -1;
			else if(this.field2>o.field2)
				return 1;
			else
				return 0;
		}
	}

}
