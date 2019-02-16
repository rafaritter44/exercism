class SpaceAge {
	
	private double years;

    SpaceAge(double seconds) {
        years = seconds / 31557600d;
    }

    double onEarth() {
        return years;
    }

    double onMercury() {
        return years / 0.2408467;
    }

    double onVenus() {
        return years / 0.61519726;
    }

    double onMars() {
        return years / 1.8808158;
    }

    double onJupiter() {
        return years / 11.862615;
    }

    double onSaturn() {
        return years / 29.447498;
    }

    double onUranus() {
        return years / 84.016846;
    }

    double onNeptune() {
        return years / 164.79132;
    }

}
