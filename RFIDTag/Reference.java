import java.util.ArrayList;

public class Reference extends RFID{
	private Reference head;
	private Reference next;
	public double weight;
	public double difference;
	public void insert(Reference reference) {
		if(head ==null) {
			head = reference;
		}else {
		insertReference(head,reference);
		}
	}
	public void insertReference(Reference head,Reference reference) {
		if(head.getID().equals(reference.getID())) {
			head.setRssi(reference.getRssi());
			head.setIdentifiedTime(reference.getIdentifiedTime());
		}else {
		if(head.next == null) {
			head.next = reference;
			return;
		}else {
			insertReference(head.next,reference);
		}
		}
	}
	public void view() {
		if(head==null) {
			System.out.println("데이터가 비었습니다.");
		}else {
			viewReference(head);
		}
	}
		public void viewReference(Reference reference) {
			if(reference==null) {
				return;
			}else {
			System.out.println("태그 아이디 : "+reference.getID()+" 태그 평균 RSSI : "+reference.getRssi()+" RSSI 표준 편차 : "+reference.getDeviation()+" 편균 인식 인터벌 : "+reference.getTime()+" 인식 횟수 : "+reference.getCount()+" 좌표 : ("+reference.getX()+","+reference.getY()+")");
			viewReference(reference.next);
			}
		}
		public void predictionKNN(Target target,int n) {
			ArrayList<Reference> sampleReference = new ArrayList<Reference>();
			comparisonKNN(head,target,sampleReference,n);
				double weightSum=0;
				for(int i=0;i<sampleReference.size();i++) {
					sampleReference.get(i).difference = Math.pow(sampleReference.get(i).getRssi()-target.getRssi(),2);
					weightSum += 1/(sampleReference.get(i).difference);
				}
				int x=0;
				int y=0;
				for(int i=0;i<sampleReference.size();i++) {
					sampleReference.get(i).weight = (1/(sampleReference.get(i).difference))/weightSum;
					sampleReference.get(i).setX(sampleReference.get(i).getX()*sampleReference.get(i).weight);
					sampleReference.get(i).setY(sampleReference.get(i).getY()*sampleReference.get(i).weight);
					x += sampleReference.get(i).getX();
					y += sampleReference.get(i).getY();
				}
				target.setX(x);
				target.setY(y);
		}
		public void comparisonKNN(Reference head,Target target,ArrayList<Reference> sampleReference,int n) {
			if(head==null) {
				return;
			}else {
				if(sampleReference.size()<n) {
					sampleReference.add(head);
				}else {
					for(int i=0;i<n;i++) {
						if(Math.abs(sampleReference.get(i).getRssi()-target.getRssi())>Math.abs(head.getRssi()-target.getRssi())) {
							sampleReference.set(i, head);
							break;
						}
					}
				}
				comparisonKNN(head.next,target,sampleReference,n);
				}
				}
		public void predictionGNN(Target target,int n) {
			Reference[] subReference = new Reference[5];
			subReference(head,target,subReference);
			Reference[] sampleReference = new Reference[n];
			Reference[] sampleReference1 = new Reference[n];
			Reference[] sampleReference2 = new Reference[n];
			Reference[] sampleReference3 = new Reference[n];
			Reference[] sampleReference4 = new Reference[n];
			sampleReference[0] = subReference[0];
			sampleReference1[0] = subReference[1];
			sampleReference2[0] = subReference[2];
			sampleReference3[0] = subReference[3];
			sampleReference4[0] = subReference[4];
			//firstReference(head,target,sampleReference);
			comparisonGNN(head,target,sampleReference,1);
			comparisonGNN(head,target,sampleReference1,1);
			comparisonGNN(head,target,sampleReference2,1);
			comparisonGNN(head,target,sampleReference3,1);
			comparisonGNN(head,target,sampleReference4,1);
			int index = selectReference(sampleReference,sampleReference1,sampleReference2,sampleReference3,sampleReference4,target);
			double weightSum =0;
			int x =0;
			int y =0;
			switch(index) {
			case 0 :
				for(int i=0;i<sampleReference.length;i++) {
					sampleReference[i].difference =  Math.pow(sampleReference[i].getRssi()-target.getRssi(),2);
					weightSum += 1/(sampleReference[i].difference);
				}
					for(int i=0;i<sampleReference.length;i++) {
						sampleReference[i].weight = (1/(sampleReference[i].difference))/weightSum;
						sampleReference[i].setX(sampleReference[i].getX()*sampleReference[i].weight);
						sampleReference[i].setY(sampleReference[i].getY()*sampleReference[i].weight);
						x += sampleReference[i].getX();
						y += sampleReference[i].getY();
					}
					target.setX(x);
					target.setY(y);
				break;
			case 1 :
				for(int i=0;i<sampleReference1.length;i++) {
					sampleReference1[i].difference =  Math.pow(sampleReference1[i].getRssi()-target.getRssi(),2);
					weightSum += 1/(sampleReference1[i].difference);
				}
					for(int i=0;i<sampleReference1.length;i++) {
						sampleReference1[i].weight = (1/(sampleReference1[i].difference))/weightSum;
						sampleReference1[i].setX(sampleReference1[i].getX()*sampleReference1[i].weight);
						sampleReference1[i].setY(sampleReference1[i].getY()*sampleReference1[i].weight);
						x += sampleReference1[i].getX();
						y += sampleReference1[i].getY();
					}
					target.setX(x);
					target.setY(y);
				break;
			case 2 :
				for(int i=0;i<sampleReference2.length;i++) {
					sampleReference2[i].difference =  Math.pow(sampleReference2[i].getRssi()-target.getRssi(),2);
					weightSum += 1/(sampleReference2[i].difference);
				}
					for(int i=0;i<sampleReference2.length;i++) {
						sampleReference2[i].weight = (1/(sampleReference2[i].difference))/weightSum;
						sampleReference2[i].setX(sampleReference2[i].getX()*sampleReference2[i].weight);
						sampleReference2[i].setY(sampleReference2[i].getY()*sampleReference2[i].weight);
						x += sampleReference2[i].getX();
						y += sampleReference2[i].getY();
					}
					target.setX(x);
					target.setY(y);
				break;
			case 3 :
				for(int i=0;i<sampleReference3.length;i++) {
					sampleReference3[i].difference =  Math.pow(sampleReference3[i].getRssi()-target.getRssi(),2);
					weightSum += 1/(sampleReference3[i].difference);
				}
					for(int i=0;i<sampleReference3.length;i++) {
						sampleReference3[i].weight = (1/(sampleReference3[i].difference))/weightSum;
						sampleReference3[i].setX(sampleReference3[i].getX()*sampleReference3[i].weight);
						sampleReference3[i].setY(sampleReference3[i].getY()*sampleReference3[i].weight);
						x += sampleReference3[i].getX();
						y += sampleReference3[i].getY();
					}
					target.setX(x);
					target.setY(y);
				break;
			case 4 :
				for(int i=0;i<sampleReference4.length;i++) {
					sampleReference4[i].difference =  Math.pow(sampleReference4[i].getRssi()-target.getRssi(),2);
					weightSum += 1/(sampleReference4[i].difference);
				}
					for(int i=0;i<sampleReference4.length;i++) {
						sampleReference4[i].weight = (1/(sampleReference4[i].difference))/weightSum;
						sampleReference4[i].setX(sampleReference4[i].getX()*sampleReference4[i].weight);
						sampleReference4[i].setY(sampleReference4[i].getY()*sampleReference4[i].weight);
						x += sampleReference4[i].getX();
						y += sampleReference4[i].getY();
					}
					target.setX(x);
					target.setY(y);
				break;
			}
		}
		public int selectReference(Reference[] sampleReference,Reference[] sampleReference1,Reference[] sampleReference2,Reference[] sampleReference3,Reference[] sampleReference4,Target target) {
			int[] rssi = new int[5]; 
			for(int i=0;i<sampleReference.length;i++) {
				rssi[0] += Math.abs(sampleReference[i].getRssi()-target.getRssi());
				rssi[1] += Math.abs(sampleReference1[i].getRssi()-target.getRssi());
				rssi[2] += Math.abs(sampleReference2[i].getRssi()-target.getRssi());
				rssi[3] += Math.abs(sampleReference3[i].getRssi()-target.getRssi());
				rssi[4] += Math.abs(sampleReference4[i].getRssi()-target.getRssi());
			}
			int index=0;
			int min = rssi[0];
			for(int i=0;i<rssi.length;i++) {
				if(min > rssi[i]) {
					min = rssi[i];
					index = i;
				}
			}
			return index;
		}
		public void subReference(Reference head,Target target,Reference[] subReference) {
			if(head==null) {
				return;
			}
			if(!fullReference(subReference)) {
				for(int i=0;i<subReference.length;i++) {
					if(subReference[i]==null) {
						subReference[i] = head;
						break;
					}
				}
			}else {
				for(int i=0;i<subReference.length;i++) {
					if(Math.abs(subReference[i].getRssi()-target.getRssi())>Math.abs(head.getRssi()-target.getRssi())) {
						subReference[i] = head;
						break;
					}
				}
			}
			subReference(head.next,target,subReference);
		}
		/*public void firstReference(Reference head,Target target,Reference[] sampleReference) {
			if(head==null) {
				return;
			}
			if(sampleReference[0]==null) {
				sampleReference[0] = head;
			}else {
				if(Math.abs(sampleReference[0].getRssi()-target.getRssi())>Math.abs(head.getRssi()-target.getRssi())) {
					sampleReference[0] = head;
			}
			}
			firstReference(head.next,target,sampleReference);
			
		}*/
		public void comparisonGNN(Reference head,Target target,Reference[] sampleReference,int index) {
			if(head==null) {
				if(sampleReference[sampleReference.length-1]==null) {
					index++;
				comparisonGNN(this.head,target,sampleReference,index);
				}else {
					return;
				}
			}else {
			if(nearArray(sampleReference,head,index)) {
				if(sampleReference[index]==null) {
					sampleReference[index] = head;
				}else {
					if(Math.abs(sampleReference[index].getRssi()-target.getRssi())>Math.abs(head.getRssi()-target.getRssi())) {
						sampleReference[index] = head;
					}
				}
			}
				comparisonGNN(head.next,target,sampleReference,index);
			}
		}
		public boolean nearNode(Reference a,Reference b) {
			if(a.getX()==b.getX()) {
				if(Math.abs(a.getY()-b.getY())<=40) {
					return true;
				}
			}else {
				if(a.getY()==b.getY()) {
					if(Math.abs(a.getX()-b.getX())<=20) {
						return true;
					}
				}
				if(Math.abs(a.getX()-b.getX())<=20) {
					if(Math.abs(a.getY()-b.getY())<=40) {
						return true;
					}
				}
			}
			return false;
		}
		public boolean nearArray(Reference[] sampleReference,Reference head,int index) {
			boolean same = false;
			boolean near = false;
			for(int i=0;i<index;i++) {
				if(sampleReference[i].equals(head)) {
					same = true;
				}else {
				if(nearNode(sampleReference[i],head)) {
						near = true;
					}
				}
			}
			if(same==true) {
				return false;
			}else {
				if(near==true) {
					return true;
				}
				return false;
			}
		}	
		public boolean fullReference(Reference[] referenceArray) {
			for(int i=0;i<referenceArray.length;i++) {
				if(referenceArray[i]==null) {
					return false;
				}
			}
			return true;
		}
}

