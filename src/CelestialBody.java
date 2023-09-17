

/**
 * Celestial Body class for NBody
 * Modified from original Planet class
 * used at Princeton and Berkeley
 * @author ola
 * @author Frannie Goodman
 * If you add code here, add yourself as @author below
 *
 *
 */
public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;

	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){
		myXPos = xp;
		myYPos = yp;
		myXVel = xv;
		myYVel = yv;
		myMass = mass;
		myFileName = filename;

	}
	

	/**
	 *
	 * @return
	 */
	public double getX() {
		return myXPos;
	}

	/**
	 *
	 * @return
	 */
	public double getY() {
		return myYPos;
	}

	/**
	 * Accessor for the x-velocity
	 * @return the value of this object's x-velocity
	 */
	public double getXVel() {
		return myXVel;
	}
	/**
	 * Return y-velocity of this Body.
	 * @return value of y-velocity.
	 */
	public double getYVel() {
		return myYVel;
	}

	/**
	 *
	 * @return
	 */
	public double getMass() {
		return myMass;
	}

	/**
	 *
	 * @return
	 */
	public String getName() {
		return myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		// r^2=dx^2 + dy^2
		double dx = b.getX() - this.myXPos;
		double dy = b.getY() - this.myYPos;
		double r = Math.sqrt(dx*dx + dy*dy);
		return r;
	}

	public double calcForceExertedBy(CelestialBody b) {
		double r = calcDistance(b);
		double m_1 = b.getMass();
		double m_2 = this.myMass;
		double G = 6.67*1e-11;
		double F = G*((m_1*m_2)/(r*r));
		return F;
	}

	public double calcForceExertedByX(CelestialBody b) {
		double F = calcForceExertedBy(b);
		double dx = b.getX() - this.myXPos;
		double r = calcDistance(b);
		double F_x = F*dx/r;
		return F_x;
	}
	public double calcForceExertedByY(CelestialBody b) {
		double F = calcForceExertedBy(b);
		double dy = b.getY() - this.myYPos;
		double r = calcDistance(b);
		double F_y = F*dy/r;
		return F_y;
	}

	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		// TODO: complete method
		double sum = 0.0;
		return sum;
	}

	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		double sum = 0.0;
		return sum;
	}

	public void update(double deltaT, 
			           double xforce, double yforce) {
		// TODO: complete method
	}

	/**
	 * Draws this planet's image at its current position
	 */
	public void draw() {
		StdDraw.picture(myXPos,myYPos,"images/"+myFileName);
	}
}
