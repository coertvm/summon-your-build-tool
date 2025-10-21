package codewarts;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class SortingHatTest {

    private static final Set<String> EXPECTED_TOOLS = Set.of("Javador", "Makeclaw", "Antforge", "Mavenmere", "Gradlewraith");

    @RepeatedTest(10)
    void summonShouldAlwaysReturnAValidTool() {
        String result = new SortingHat().summon();
        assertTrue(EXPECTED_TOOLS.contains(result), "Unexpected tool: " + result);
    }
}
