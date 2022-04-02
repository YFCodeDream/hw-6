public class SetBuilder {
    public static final int STEP = 100;
    public static final int MAX = 2_000;
    
    public static void main(String[] args) {
	RunTimer rt = new RunTimer();
	CSVWriter csv = new CSVWriter("build-times.csv");

	csv.addEntry("size");
	csv.addEntry("build time ArraySimpleList");
	csv.addEntry("build time LinkedSimpleList");
	csv.endLine();

	SimpleUSet<Integer> aslSet;
	SimpleUSet<Integer> lslSet;
	

	for (int i = STEP; i <= MAX; i += STEP) {
	    aslSet = new ListSimpleUSet<Integer>(new ArraySimpleList<Integer>());
	    lslSet = new ListSimpleUSet<Integer>(new LinkedSimpleList<Integer>());

	    csv.addEntry(i);

	    rt.reset();
	    rt.start();
	    buildSet(aslSet, i);
	    rt.stop();
	    csv.addEntry(rt.getElapsedMillis());

	    rt.reset();
	    rt.start();
	    buildSet(lslSet, i);
	    rt.stop();
	    csv.addEntry(rt.getElapsedMillis());
	    
	    csv.endLine();
	}

	csv.close();
    }

    static void buildSet(SimpleUSet<Integer> set, int size) {
	for (int i = 0; i < size; ++i) {
	    set.add(i);
	}
    }
}
