package aima.test.core.unit.search.informed;

import aima.core.agent.Action;
import aima.core.environment.eightpuzzle.BidirectionalEightPuzzleProblem;
import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.environment.eightpuzzle.EightPuzzleFunctions;
import aima.core.environment.map.*;
import aima.core.search.framework.Node;
import aima.core.search.agent.SearchAgent;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.problem.GeneralProblem;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.framework.qsearch.QueueSearch;
import aima.core.search.framework.qsearch.TreeSearch;
import aima.core.search.informed.AStarSearch;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

public class AStarSearchTest {

	@Test
	public void testAStarSearch() {
		// added to narrow down bug report filed by L.N.Sudarshan of
		// Thoughtworks and Xin Lu of UCI
		try {
			// EightPuzzleBoard extreme = new EightPuzzleBoard(new int[]
			// {2,0,5,6,4,8,3,7,1});
			// EightPuzzleBoard extreme = new EightPuzzleBoard(new int[]
			// {0,8,7,6,5,4,3,2,1});
			EightPuzzleBoard board = new EightPuzzleBoard(new int[] { 8, 2, 4, 8, 0, 8, 8, 3, 1 });

			Problem<EightPuzzleBoard, Action> problem = new BidirectionalEightPuzzleProblem(board);
			SearchForActions<EightPuzzleBoard, Action> search = new AStarSearch<>(new GraphSearch<>(),
					EightPuzzleFunctions::getManhattanDistance);
			SearchAgent<Object, EightPuzzleBoard, Action> agent = new SearchAgent<>(problem, search);
			Assert.assertEquals(18, agent.getActions().size());
			Assert.assertEquals("618", // "618" GraphSearchReduced Frontier
					agent.getInstrumentation().getProperty("nodesExpanded"));
			Assert.assertEquals("329", // "329" GraphSearchReduced Frontier
					agent.getInstrumentation().getProperty("queueSize"));
			Assert.assertEquals("330", // "330" GraphSearchReduced Frontier
					agent.getInstrumentation().getProperty("maxQueueSize"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception thrown");
		}
	}
	
	@Test
	public void testAStarSearch2() {
		// added to narrow down bug report filed by L.N.Sudarshan of
		// Thoughtworks and Xin Lu of UCI
		try {
			// EightPuzzleBoard extreme = new EightPuzzleBoard(new int[]
			// {2,0,5,6,4,8,3,7,1});
			// EightPuzzleBoard extreme = new EightPuzzleBoard(new int[]
			// {0,8,7,6,5,4,3,2,1});
			EightPuzzleBoard board = new EightPuzzleBoard(new int[] { 8, 2, 4, 8, 0, 8, 8, 3, 1 });

			Problem<EightPuzzleBoard, Action> problem = new BidirectionalEightPuzzleProblem(board);
			SearchForActions<EightPuzzleBoard, Action> search = new AStarSearch<>(new GraphSearch<>(),
					EightPuzzleFunctions::getNumberOfMisplacedTiles);
			SearchAgent<Object, EightPuzzleBoard, Action> agent = new SearchAgent<>(problem, search);
			Assert.assertEquals(18, agent.getActions().size());
			Assert.assertEquals("2837", // "2837" GraphSearchReduced Frontier
					agent.getInstrumentation().getProperty("nodesExpanded"));
			Assert.assertEquals("1376", // "1376" GraphSearchReduced Frontier
					agent.getInstrumentation().getProperty("queueSize"));
			Assert.assertEquals("1379", // "1379" GraphSearchReduced Frontier
					agent.getInstrumentation().getProperty("maxQueueSize"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception thrown");
		}
	}
	
	@Test
	public void testAStarSearch3() {
		// added to narrow down bug report filed by L.N.Sudarshan of
		// Thoughtworks and Xin Lu of UCI
		try {
			// EightPuzzleBoard extreme = new EightPuzzleBoard(new int[]
			// {2,0,5,6,4,8,3,7,1});
			// EightPuzzleBoard extreme = new EightPuzzleBoard(new int[]
			// {0,8,7,6,5,4,3,2,1});
			EightPuzzleBoard board = new EightPuzzleBoard(new int[] { 8, 2, 4, 8, 0, 8, 8, 3, 1 });

			Problem<EightPuzzleBoard, Action> problem = new BidirectionalEightPuzzleProblem(board);
			SearchForActions<EightPuzzleBoard, Action> search = new AStarSearch<>(new TreeSearch<>(),
					EightPuzzleFunctions::getManhattanDistance);
			SearchAgent<Object, EightPuzzleBoard, Action> agent = new SearchAgent<>(problem, search);
			Assert.assertEquals(18, agent.getActions().size());
			Assert.assertEquals("46763", // "46763" TreeSearchReduced Frontier
					agent.getInstrumentation().getProperty("nodesExpanded"));
			Assert.assertEquals("77188", // "77188" TreeSearchReduced Frontier
					agent.getInstrumentation().getProperty("queueSize"));
			Assert.assertEquals("77189", // "77189" TreeSearchReduced Frontier
					agent.getInstrumentation().getProperty("maxQueueSize"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception thrown");
		}
	}
	
	@Test
	public void testAStarSearch4() {
		// added to narrow down bug report filed by L.N.Sudarshan of
		// Thoughtworks and Xin Lu of UCI
		try {
			// EightPuzzleBoard extreme = new EightPuzzleBoard(new int[]
			// {2,0,5,6,4,8,3,7,1});
			// EightPuzzleBoard extreme = new EightPuzzleBoard(new int[]
			// {0,8,7,6,5,4,3,2,1});
			EightPuzzleBoard board = new EightPuzzleBoard(new int[] { 8, 2, 4, 8, 0, 8, 8, 3, 1 });

			Problem<EightPuzzleBoard, Action> problem = new BidirectionalEightPuzzleProblem(board);
			SearchForActions<EightPuzzleBoard, Action> search = new AStarSearch<>(new TreeSearch<>(),
					EightPuzzleFunctions::getNumberOfMisplacedTiles);
			SearchAgent<Object, EightPuzzleBoard, Action> agent = new SearchAgent<>(problem, search);
			Assert.assertEquals(18, agent.getActions().size());
			Assert.assertEquals("2444642", // "2444642" TreeSearchReduced Frontier
					agent.getInstrumentation().getProperty("nodesExpanded"));
			Assert.assertEquals("4562549", // "4562549" TreeSearchReduced Frontier
					agent.getInstrumentation().getProperty("queueSize"));
			Assert.assertEquals("4562550", // "4562549" TreeSearchReduced Frontier
					agent.getInstrumentation().getProperty("maxQueueSize"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception thrown");
		}
	}
}
