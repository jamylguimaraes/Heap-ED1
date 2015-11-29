import java.util.Scanner;

class Heap {
	private int nItem;
	public Heap(int nItem){this.nItem = nItem;}
	
	public static void heapSort(int[] v)
	{  
	  buildMaxHeap(v); 
	  int n = v.length;
	 
	  for (int i = v.length - 1; i > 0; i--) 
	  { 
	     swap(v, i , 0);
	     maxHeapify(v, 0, --n);
	  }
	   
	}
	private static void buildMaxHeap(int[] v) //Procedimento para criar o heap
	{ 
	   for (int i = v.length/2 - 1; i >= 0; i--)
	      maxHeapify(v, i , v. length ); //Chamada do metodo recursivamente
	}
	private static void maxHeapify(int[] v, int pos, int n) //Transforma um vetor em um heap usando a abordagem bottom-up
	{ 
	   int maxi; 
	   int left = 2 * pos +1;
	   int right = 2 * pos + 2;
	   if ( (left < n) && (v[left] > v[pos]) )
	   {
	      maxi = left;
	   }
	   else
	   {
	      maxi = pos;
	   }
	   if (right < n && v[right] > v[maxi]) 
	   { 
	      maxi = right;
	   }
	   if (maxi != pos) 
	   {
	      swap(v, pos, maxi);
	      maxHeapify(v, maxi, n);
	   }
	}
	 
	public static void swap ( int[ ] v, int j, int aposJ )
	{
	   int aux = v [ j ];
	   v [ j ] = v [ aposJ ];
	   v [ aposJ ] = aux;
	}
}

class Main{
	
	private static final String FIRSTROUND = "1";
	private static final String SECONDROUND = "2";
	private static final String THIRDROUND = "3";
	private static final String FOURTHROUND = "4";
	
	private static final int FIRSTPRIO = 1;
	private static final int SECONDPRIO = 2;
	private static final int THIRDPRIO = 3;
	private static final int FOURTHPRIO = 4;

	public static void main(String args[]){
		Heap h;
		Scanner s = new Scanner(System.in);
		int nItem = s.nextInt();
		h = new Heap(nItem);
		String[] v = new String[nItem];
		int[] vi = new int[v.length];
		if(s.hasNext()){
			for(int j = 0; j< nItem; j++){
				v[j] = s.next();
				v[j] = v[j].replace(":", "");
				if(v[j].charAt(4) == 'v'){ v[j] = v[j].replace("v", ""); v[j] = FIRSTPRIO+v[j]; }
				if(v[j].charAt(4) == 'l'){ v[j] = v[j].replace("l", ""); v[j] = SECONDPRIO+v[j]; }
				if(v[j].charAt(4) == 'a'){ v[j] = v[j].replace("a", ""); v[j] = THIRDPRIO+v[j]; }
				if(v[j].charAt(4) == 'b'){ v[j] = v[j].replace("b", ""); v[j] = FOURTHPRIO+v[j]; }
				if(
						Integer.parseInt(v[j].substring(1)) >= 0000 && Integer.parseInt(v[j].substring(1)) <= 559){
							v[j] = FIRSTROUND+v[j];
				}
				if(
						Integer.parseInt(v[j].substring(1)) >= 600 && Integer.parseInt(v[j].substring(1)) <= 1159){
							v[j] = SECONDROUND+v[j];
				}
				if(
						Integer.parseInt(v[j].substring(1)) >= 1200 && Integer.parseInt(v[j].substring(1)) <= 1759){
							v[j] = THIRDROUND+v[j];
				}
				if(
						Integer.parseInt(v[j].substring(1)) >= 1800 && Integer.parseInt(v[j].substring(1)) <= 2359){
							v[j] = FOURTHROUND+v[j];
				}
				vi[j] = Integer.parseInt(v[j]);
			}
		}
		h.heapSort(vi);
		for(int j = 0; j < vi.length; j++){
			v[j] = Integer.toString(vi[j]);
			v[j] = v[j].substring(1, 6);
			
			if(v[j].charAt(0) == Integer.toString(FIRSTPRIO).charAt(0)){
				v[j] = v[j]+'v'; v[j] = v[j].substring(1, 6);
				}else{ 
					if(v[j].charAt(0) == Integer.toString(SECONDPRIO).charAt(0)){
						v[j] = v[j]+'l'; v[j] = v[j].substring(1, 6);
					}else{
						if(v[j].charAt(0) == Integer.toString(THIRDPRIO).charAt(0)){
							v[j] = v[j]+'a'; v[j] = v[j].substring(1, 6);
						}else{ 
							if(v[j].charAt(0) == Integer.toString(FOURTHPRIO).charAt(0)){
							v[j] = v[j]+'b';  v[j] = v[j].substring(1, 6);
							}
						}
					}
				}
			System.out.print(v[j].substring(0, 2)+":"+v[j].substring(2, 5)+" ");
		}
	}
}
