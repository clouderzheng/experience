��¡ģʽ
ʵ��Cloneable�ӿ� ��ʵ��clone����

����ģʽ ˫������ ˫���ж�
if(instance == null){  //���߳�����������  ͬʱû��ͬʱ���� ��Ҫ�ڴ���֮���ٴ��ж�
	lock(current){
		if(instance == null){
			instance = new instance();
		}
	}
}


��Ԫģʽ 
String name  = "nihgt"
String lastName = "night"
name.equal(lastName) == true