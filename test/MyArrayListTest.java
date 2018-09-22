import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MyArrayListTest {

    MyArrayList zero;
    MyArrayList one;
    MyArrayList many;

    @BeforeEach
    public void setUp() {
        zero = new MyArrayList();
        one = new MyArrayList();
        many = new MyArrayList();
    }

    @Test
    public void isEmpty_beforeAdding_isTrue() {
        assertThat(zero.isEmpty()).isTrue();
    }

    @Test
    public void isEmpty_afterAdding_isFalse() {
        one.add(8);
        assertThat(one.isEmpty()).isFalse();
    }

    @Test
    public void size_beforeAdding_returnsZero() {
        assertThat(zero.size()).isEqualTo(0);
    }

    @Test
    public void size_afterAdding_returnsSize() {
        one.add(-4);

        many.add(42);
        many.add(13);
        many.add(9);

        assertThat(one.size()).isEqualTo(1);
        assertThat(many.size()).isEqualTo(3);
    }

    @Test
    public void get_elementAt_Index() {
        one.add(12);

        many.add(3);
        many.add(6);
        many.add(10);

        assertThat(one.get(0)).isEqualTo(12);
        assertThat(many.get(1)).isEqualTo(6);
    }

    @Test
    public void indexOf_returns_ElementIndex() {
        //arranging
        many.add(15);
        many.add(8);
        many.add(34);

        //act
        int first = many.indexOf(15);
        int second = many.indexOf(8);
        int third = many.indexOf(34);

        //assert
        assertThat(first).isEqualTo(0);
        assertThat(second).isEqualTo(1);
        assertThat(third).isEqualTo(2);
    }

    @Test
    public void indexOf_elementNotInArrayList() {

        many.add(40);
        many.add(15);
        many.add(72);

        int index = many.indexOf(41);

        assertThat(index).isEqualTo(-1);


    }

    @Test
    public void contains_ifElementExists_isTrue() {
        one.add(45);

        //act
        boolean result = one.contains(45);

        //assert
        assertThat(result).isTrue();
    }

    @Test
    public void contains_ifElementDoesNotExist_isFalse() {
        one.add(21);

        boolean contains = one.contains(20);

        assertThat(contains).isFalse();
    }

    @Test
    public void set_replacesElement_atIndex() {
        one.add(12);

        int replaced = one.set(0, 5);

        assertThat(replaced).isEqualTo(12);
        assertThat(one.get(0)).isEqualTo(5);


    }

    @Test
    public void set_replacesElement_atAnotherIndex() {
        many.add(24);
        many.add(30);
        many.add(45);
        many.add(-1);
        many.add(16);

        int first = many.set(1, -7);
        int second = many.set(2, 0);

        assertThat(first).isEqualTo(30);
        assertThat(many.get(1)).isEqualTo(-7);

        assertThat(second).isEqualTo(45);
        assertThat(many.get(2)).isEqualTo(0);
    }

    @Test
    public void add_ElementAtIndex() {

        many.add(1);
        many.add(55);
        many.add(0, 40);

        assertThat(many.get(0)).isEqualTo(40);
        assertThat(many.get(1)).isEqualTo(1);
        assertThat(many.get(2)).isEqualTo(55);
    }

    @Test

    public void add_ElementAtAnotherIndex() {

        many.add(43);
        many.add(6);
        many.add(34);
        many.add(18);
        many.add(27);
        many.add(2);

        many.add(3, -400);

        //assert
        assertThat(many.get(3)).isEqualTo(-400);
        assertThat(many.get(4)).isEqualTo(18);
    }

    @Test
    public void ensureCapacity_increasesArraySize_whenNeeded(){
        MyArrayList list = new MyArrayList(2);
        list.add(3);
        list.add(5);
        list.add(9);

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(2)).isEqualTo(9);
    }


}