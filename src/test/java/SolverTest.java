import ch.supsi.halabi.CoppaAlgoritmi.Main;
import org.junit.Test;

public class SolverTest {

    private final String inputPath = "problems/";
    private final String outputPath = "../solved_tours/";


    @Test(timeout = 181000)
    public void ch130() {
        String[] args = {"ch130", "1554104699057", inputPath, outputPath};
        Main.main(args);
    }

    @Test(timeout = 181000)
    public void d198() {
        String[] args = {"d198", "1554404587246", inputPath, outputPath};
        Main.main(args);
    }

    @Test(timeout = 181000)
    public void eil76() {
        String[] args = {"eil76", "155106242827", inputPath, outputPath};
        Main.main(args);
    }

    @Test(timeout = 181000)
    public void fl1577() {
        String[] args = {"fl1577", "1555458570325", inputPath, outputPath};
        Main.main(args);
    }

    @Test(timeout = 181000)
    public void kroA100() {
        String[] args = {"kroA100", "1554104882992", inputPath, outputPath};
        Main.main(args);
    }

    @Test(timeout = 181000)
    public void lin318() {
        String[] args = {"lin318", "1556347251330", inputPath, outputPath};
        Main.main(args);
    }

    @Test(timeout = 181000)
    public void pcb442() {
        String[] args = {"pcb442", "1555228717892", inputPath, outputPath};
        Main.main(args);
    }

    @Test(timeout = 181000)
    public void pr439() {
        String[] args = {"pr439", "1555104967032", inputPath, outputPath};
        Main.main(args);
    }

    @Test(timeout =181000 )
    public void rat783() {
        String[] args = {"rat783", "1554371112973", inputPath, outputPath};
        Main.main(args);
    }

    @Test(timeout = 181000)
    public void u1060() {
        String[] args = {"u1060", "1554351921574", inputPath, outputPath};
        Main.main(args);
    }
}

