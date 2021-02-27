import java.util.Iterator;

/**
 * This class is concrete Iterator Class that implements Iterator interface.
 */
public class SatelliteIterator  implements Iterator{
    /**
     * Storing elements in 2D array as spirally clockwise in 1D array.
     */
    private Integer[] store;
    /**
     * First position.
     */
    int position = 0;
    /**
     * Given 2D array.
     */
    private Integer data[][];

    /**
     * Constructor.
     * @param data is 2D data.
     */
    public SatelliteIterator(Integer[][] data){
        this.data = data;
        store=new Integer[data.length*data[0].length];
        spirallyClockwise(data.length,data[0].length);
    }

    /**
     * Traverse 2D array as spirally clockwise.
     * @param endRow last row.
     * @param endColumn last column.
     */
    private void spirallyClockwise(int endRow, int endColumn) {
        int startColumn = 0;
        int startRow = 0;
        int k = 0;

        while(startColumn < endColumn && startRow < endRow ) {
            for (int i = startColumn;i <endColumn; i++) {
                store[k] = data[startRow][i];
                k++;
            }
            startRow++;
            for(int i = startRow; i < endRow; i++) {
                store[k] = data[i][endColumn-1];
                k++;
            }
            endColumn--;
            if(startRow < endRow) {
                for (int i = endColumn-1; i >= startColumn; i--) {
                    store[k] = data[endRow-1][i];
                    k++;
                }
                endRow--;
            }
            if( startColumn <  endColumn) {
                for (int i = endRow-1; i >= startRow; i--) {
                    store[k] = data[i][startColumn];
                    k++;
                }
                startColumn++;
            }
        }
    }
    /**
     * Controlling whether there is an item in next of the iterator or not.
     * @return true if there is an item next or false if no item.
     */
    @Override
    public boolean hasNext() {
        if (position >= store.length || store[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Returns next item of iterator.
     * @return next item of iterator.
     */
    @Override
    public Object next() {
        return store[position++];
    }
}
