package javacollection.map;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Description: ${DESCRIPTION}
 * @CreateDate: 2019/6/23 下午1:52
 * @Author: longlong.an
 * @Email: longlong.an.o@nio.com
 */
public class FlyweightMap extends AbstractMap<String, String> {


    private static class Entry implements Map.Entry<String, String> {

        int index;

        public Entry(int index) {
            this.index = index;
        }

        @Override
        public String getKey() {
            return Countries.COUNTRIES[index][0];
        }

        @Override
        public String getValue() {
            return Countries.COUNTRIES[index][1];
        }

        @Override
        public String setValue(String value) {
            throw  new UnsupportedOperationException();
        }

        @Override
        public boolean equals(Object obj) {
            return Countries.COUNTRIES[index][0].equals(obj);
        }

        @Override
        public int hashCode() {
            return Countries.COUNTRIES[index][0].hashCode();
        }
    }

    private static class EntrySet extends AbstractSet<Map.Entry<String, String>> {
        private int size;

        EntrySet(int size) {
            if (size > Countries.COUNTRIES.length) {
                this.size = Countries.COUNTRIES.length;
            } else {
                this.size = size;
            }
        }

        @Override
        public Iterator<Map.Entry<String, String>> iterator() {
            return new Iter();
        }

        @Override
        public int size() {
            return size;
        }

        private  class Iter implements Iterator<Map.Entry<String, String>> {
            private Entry mEntry = new Entry(-1);

            @Override
            public boolean hasNext() {
                return mEntry.index < size - 1;
            }

            @Override
            public Map.Entry<String, String> next() {
                mEntry.index++;
                return mEntry;
             }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

    }

    @Override
    public Set<Map.Entry<String, String>> entrySet() {
        return new EntrySet(Countries.COUNTRIES.length);
    }

    static Map<String, String> select(final int size) {
        return new FlyweightMap() {
            @Override
            public Set<Map.Entry<String, String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }
}
