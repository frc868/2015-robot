package com.techhounds.commands.feeder;

import edu.wpi.first.wpilibj.command.Command;
import com.techhounds.subsystems.FeederSubsystem;;

/**
 * @author Anonymous :1
 */
public class SetFeeder extends Command {
	
	public FeederSubsystem feed;
	
	public Double power;
	private Boolean position, toggle;
	
    public SetFeeder(double power, boolean position) {
        this(power);
        this.position = position;
    }
    
    public SetFeeder(double power){
    	feed = FeederSubsystem.getInstance();
    	requires(feed);
    	this.power = power;
    }
    
    public SetFeeder(boolean position){
    	feed = FeederSubsystem.getInstance();
    	requires(feed);
    	this.position = position;
    }
    
    public SetFeeder(boolean toggle, boolean doesntMatter) {
    	feed = FeederSubsystem.getInstance();
    	requires(feed);
    	this.toggle = toggle;
    }
    
    public SetFeeder(boolean toggle, double direction) {
    	this(direction);
    	this.toggle = toggle;
    }
    
    protected void initialize() {
    	
    	if(toggle != null && toggle) {
    		if(power != null) {
    			if(power == FeederSubsystem.FEED_IN)
    				feed.setPower(feed.getPower() != FeederSubsystem.STOPPED ? FeederSubsystem.STOPPED : FeederSubsystem.FEED_IN);
    			else if(power == FeederSubsystem.FEED_OUT)
    				feed.setPower(feed.getPower() != FeederSubsystem.STOPPED ? FeederSubsystem.STOPPED : FeederSubsystem.FEED_OUT);
    		} else {
    			feed.setPosition(!feed.getPosition());
    		}
    	} else {
	    	if (power != null)
	    		feed.setPower(power);
	    	if (position != null)
	    		feed.setPosition(position);
    	}
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	end();
    }
}
