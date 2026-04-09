package it.unibo.pps.polyglot.a05b

import it.unibo.pps.polyglot.a05b.Logics

import scala.util.Random

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a05b/sol2/ */
case class LogicsImpl(private val gridSize: Int) extends Logics:


    private var tickCount: Int = 0
    private val random: Random = new Random()
    private val initial: (Int, Int) = (random.nextInt(gridSize-2)+1, random.nextInt(gridSize-2)+1)


    override def tick(): Unit = tickCount = tickCount + 1
/*
    override def isOver: Boolean = initial match {
      case (_, y) if (y-tickCount < 0)  => true
      case (x, _) if (x-tickCount < 0)  => true
      case (_, y) if (y+tickCount >= this.gridSize)  => true
      case (x, _) if (x+tickCount >= this.gridSize)  => true
      case (_,_) => false
    }*/

    override def isOver: Boolean =
      val (x, y) = initial
      y - tickCount < 0 ||
        y + tickCount >= gridSize ||
        x - tickCount < 0 ||
        x + tickCount >= gridSize

    override def hasElement(x: Int, y: Int): Boolean =
      val (ix, iy) = initial
      (x == ix && math.abs(y - iy) <= tickCount) ||
      (y == iy && math.abs(x - ix) <= tickCount) ||
      (x - y == ix - iy && math.abs(x - ix) <= tickCount) ||
      (x + y == ix + iy && math.abs(x - ix) <= tickCount)


/*
public class LogicsImpl implements Logics {

	private final int gridSize;
	private Pair<Integer,Integer> initial;
	private int tickCount = 0;
	private Random random = new Random();

  	@Override
	public boolean isOver() {
		return initial.getY()-tickCount < 0 || initial.getY()+tickCount >= this.gridSize ||
				initial.getX()-tickCount < 0 || initial.getX()+tickCount >= this.gridSize;
	}

    public LogicsImpl(int gridSize){
    	this.gridSize = gridSize;
    	this.initial = new Pair<>(random.nextInt(gridSize-2)+1,random.nextInt(gridSize-2)+1);
    }

    @Override
	public void tick() {
		this.tickCount = this.tickCount+1;
	}

	@Override
	public boolean hasElement(int x, int y){
		return (x == initial.getX() && Math.abs(y-initial.getY()) <= tickCount) ||
				(y == initial.getY() && Math.abs(x-initial.getX()) <= tickCount) ||
				(x-y == initial.getX()-initial.getY() && Math.abs(x-initial.getX()) <= tickCount) ||
				(x+y == initial.getX()+initial.getY() && Math.abs(x-initial.getX()) <= tickCount);
	}


}

*/