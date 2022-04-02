public class ListBuildTimer {

    public static final int STEP = 100;
    public static final int MAX = 10_000;
    
    public static void main(String[] args) {
	SimpleList<Integer> list;

	RunTimer rt = new RunTimer();
	CSVWriter csv = new CSVWriter("build-times.csv");

	csv.addEntry("size");
	csv.addEntry("build time back (ms)");
	csv.addEntry("build time front (ms)");	
	csv.endLine();
	
	for (int i = STEP; i <= MAX; i += STEP) {
	    list = new ArraySimpleList<Integer>();

	    rt.reset();
	    rt.start();
	    buildListBack(list, i);
	    rt.stop();

	    csv.addEntry(i);
	    csv.addEntry(rt.getElapsedMillis());

	    rt.reset();
	    rt.start();
	    buildListFront(list, i);
	    rt.stop();

	    csv.addEntry(rt.getElapsedMillis());
	    csv.endLine();
	    

	}

	csv.close();
    }

    static void buildListBack(SimpleList<Integer> list, int size) {
	for (int i = 0; i < size; i++) {
	    list.add(i, 0);
	}
    }

    static void buildListFront(SimpleList<Integer> list, int size) {
	for (int i = 0; i < size; i++) {
	    list.add(0, 0);
	}
    }
    
}
