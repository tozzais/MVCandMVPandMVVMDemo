package com.xmm.architecture;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        State state = State.TWO;
        System.out.println(state.isAtLeast(State.ONE));
        System.out.println(state.isAtLeast(State.TWO));
        System.out.println(state.isAtLeast(State.THREE));


    }
    public enum State{

        THREE,
        TWO,
        ONE;
        public boolean isAtLeast(State state) {
            return compareTo(state) >= 0;
        }

    }
}