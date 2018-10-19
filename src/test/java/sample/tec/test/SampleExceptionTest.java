package sample.tec.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class SampleExceptionTest {

    //Set the expected parameter @Test(expected = FileNotFoundException.class)
    @Test(expected = FileNotFoundException.class)
    public void testReadFile() throws IOException {
        FileReader reader = new FileReader("test.txt");
        reader.read();
        reader.close();
    }

    //Using try catch
    @Test
    public void testReadFile2() {
        try {
            FileReader reader = new FileReader("test.txt");
            reader.read();
            reader.close();
            fail("Expected an IOException to be thrown");
        } catch (IOException e) {
            assertThat(e.getMessage(), is("test.txt (No such file or directory)"));
        }

    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testReadFile3() throws IOException {

        thrown.expect(IOException.class);
        thrown.expectMessage(startsWith("test.txt (No such file or directory)"));
        FileReader reader = new FileReader("test.txt");
        reader.read();
        reader.close();
    }
}
