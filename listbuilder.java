import java.util.ArrayList;
import java.util.Arrays;

public class listbuilder{
    
// builds a list of numbers upto 65535 that are a multiple of the given number  
     static public ArrayList<Integer> make_list(MakeLists by){
        ArrayList<Integer> empty = new ArrayList<Integer>();
        for(int i=0; i < 65535; i = i + 1 ) {
            if(by.apply(i)) {
                empty.add(i);
            }
        }
        return empty;

    }

    // builds a list of  prime numbers 
    static public ArrayList<Integer> makePrimes() {
        ArrayList<Integer> empty = new ArrayList<Integer>();
        MakeLists b2 = new ByTwo();
        MakeLists b3 = new Bythree();
        MakeLists b5 = new Byfive();
        MakeLists b7 = new Byseven();
        for(int i = 0; i < 65535; i = i + 1) {
            if(!b2.apply(i) && !b3.apply(i) && !b5.apply(i) && !b7.apply(i)) {
                empty.add(i);
            }
        }
        return empty;
    }
}

     interface MakeLists {
        boolean apply(int i);
    }


     class ByTwo implements MakeLists {

        
        @Override
        public boolean apply(int i) {
            return i % 2 == 0;
        }
        
    }

     class Bythree implements MakeLists {

        @Override
        public boolean apply(int i) {
            return i % 3 == 0;
        }
        
    }

     class Byfive implements MakeLists {

        @Override
        public boolean apply(int i) {
            return i % 5 == 0;
        }
        
    }

    class Byseven implements MakeLists {

        @Override
        public boolean apply(int i) {
            return i % 7 == 0;
        }
        
    }

    class ByAny implements MakeLists {

        int by;

        ByAny(int by) {
            this.by = by;
        }
        @Override
        public boolean apply(int i) {
            return i % this.by == 0;
        }
    }
