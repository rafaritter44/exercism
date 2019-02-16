public class Darts {

	private double x;
	private double y;
	
    public Darts(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public int score() {
        double distanceFromCenter = distanceFromCenter(x, y);
        if(distanceFromCenter <= 1d)
        	return 10;
        if(distanceFromCenter <= 5d)
        	return 5;
        if(distanceFromCenter <= 10d)
        	return 1;
        return 0;
    }
    
    private double distanceFromCenter(double x, double y) {
    	return distance(0d, 0d, x, y);
    }
    
    private double distance(double x1, double y1, double x2, double y2) {
    	return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

}
