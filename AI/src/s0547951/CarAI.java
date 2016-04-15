package s0547951;

import lenz.htw.ai4g.ai.AI;
import lenz.htw.ai4g.ai.DriverAction;

public class CarAI extends AI {
	
	public CarAI(lenz.htw.ai4g.ai.Info info) {
		super(info);
	}

	@Override
	public String getName() {
		return "Juri";
	}

	@Override
	public DriverAction update(boolean arg0) {
		int speed = 1;
		float angle = 0.f;
		
		double adjacent = info.getCurrentCheckpoint().getX() - info.getX();
		double opposite = info.getCurrentCheckpoint().getY() - info.getY();
		
		double targetAngle = Math.atan2(opposite, adjacent);
		double orientation = info.getOrientation();
		
		if (orientation < 0 && !(orientation < targetAngle && orientation > targetAngle-Math.PI)) {
			orientation = Math.PI*2 - orientation;
		}
		
		angle = (float) (targetAngle - orientation);
		
		System.out.println("Ankathete: " + adjacent + " px");
		System.out.println("Gegenkathete: " + opposite + " px");
		System.out.println("Winkel zum Checkpoint: " + targetAngle + " (Bogenmaﬂ)");
		System.out.println("Winkel des Autos: " + info.getOrientation() + " (Bogenmaﬂ)");
		System.out.println("Lenkung: " + angle);	
		System.out.println("Drehgeschwindigkeit: " + info.getAngularVelocity());
		
		return new DriverAction(speed, angle);
	}
	
//	@Override
//	public String getTextureResourceName() {
//		return "/s0547951/car.png";
//	}
	
	@Override
	public boolean isEnabledForRacing() {
		return true;
	}
	
	@Override
	public void doDebugStuff() {
		super.doDebugStuff();
	}

}
