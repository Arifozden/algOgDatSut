/*public class Consumers {
    class Array<T> implements Iterable<T>{
        T[] array;
        private class Array Iterator<T> implements Iterable<T>{
            int teller;
            public Array Iterator (){teller=0;
        }
        public boolean hasNext(){
                return!(teller>=array.length)
            }

    }
}*/
/*
consumers

4 typer funksjoner som ofte dukker opp
Consumer<T> : Tar inn T, gir ut ingenting
                void Consumer (T t)

Supplier<T>  : Tar inn ingenting, men git ut T
                T supply ();

sammenheng mellom suppliers og iterators

Predicate<T> : tar inn T, gir ut true eller false

Comparator<T> : tar inn 2 T, gir ut int
                gir ut noe negativt om a<b
                gir ut noe positivt om a>b
                null om a=b
 */