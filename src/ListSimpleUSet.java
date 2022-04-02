public class ListSimpleUSet<E> implements SimpleUSet<E> {
    private SimpleList<E> list;

    public ListSimpleUSet() {
	list = new ArraySimpleList<E>();
    }

    // SimpleUSet<Integer> set = new ListSimpleUSet<Integer>(new LinkedSimpleList<Integer>())
    public ListSimpleUSet(SimpleList<E> list) {
	this.list = list;
    }

    public int size() {
	return list.size();
    }

    public boolean isEmpty() {
	return list.isEmpty();
    }

    /**
     * <p>Add a new element to the set. This method first checks if
     * the set already contains an element <code>y</code> that is
     * equal to the element <code>x</code> being added (i.e.,
     * <code>y</code> satisfies <code>x.equals(y)</code>). If no such
     * element is found then <code>x</code> is added to the set, and
     * the value <code>true</code> is returned. If such an element
     * <code>y</code> is found, then the set is not modified and the
     * method returns <code>false</code></p>
     *
     * <p>Formally, if the <code>SimpleUSet</code> is in state <code>S
     * = {x_1, x_2, ..., x_m}</code>, then after a call to
     * <code>add(x)</code>, the state state is not modified if there
     * exists some <code>x_i</code> in <code>S</code> satisfying
     * <code>x.equals(x_i)</code>. Otherwise, the state is updated to
     * <code>S = {x_1, x_2, ..., x_n, x}</code>.</p>
     *
     * @param x the element to be added to the set
     * @return <code>true</code> if and only if the element was successfully added
     */
    public boolean add(E x) {

	// check if x is already in set
	for (int i = 0; i < list.size(); i++) {
	    
	    if (x.equals(list.get(i))) {
		// x already there
		return false;
	    }
					
	}

	list.add(list.size(), x);
	return true;	
    }

    /**
     * <p>Remove an element equal to <code>x</code> from the
     * set. Specifically, if the set contains an element
     * <code>y</code> satisfying <code>x.equals(y)</code>, then
     * <code>y</code> is removed from the set and returned. Otherwise,
     * the method returns the value <code>null</code>.</p>
     *
     * <p>More formally, if the <code>SimpleUSet</code> has state
     * <code>S = {x_1, x_2, ..., x_n}</code> and there is no element
     * <code>x_i</code> in <code>S</code> satisfying
     * <code>x.equals(x_i)</code>, then the value <code>null</code> is
     * returned, and <code>S</code> remains unchanged. Otherwise, if
     * <code>x.equals(x_i)</code>, then the state is updated to
     * <code>{x_1, x_2,...,x_{i-1}, x_{i+1},...,x_{n}}</code>, and
     * <code>x_i</code> is returned.</p>
     *
     * @param x the element to be removed from the set (if present)
     * @return an element <code>y</code> in <code>S</code> satisfying
     * <code>x.equals(y)</code>, if present, and <code>null</code>
     * otherwise
     */
    public E remove(E x) {



    }


    /**
     * <p>Find an element equal to <code>x</code> in the set. If such
     * an element <code>y</code> satisfying <code>x.equals(y)</code>
     * is found, return it. Otherwise return <code>null</code>. This
     * method does not change the state of the set.</p>
     *
     * @param x the element to be found in the set
     * @return an element <code>y</code> in the set satisfying
     * <code>x.equals(y)</code>, if present, and <code>null</code>
     * otherwise
     */
    public E find(E x) {


	
    }
    
}
