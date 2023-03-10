package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import frc.lib.util.SwerveModuleConstants;

public final class Constants {
    public static final double stickDeadband = 0.1;

    public static final class Swerve {
        public static final int pigeonID = 1;
        public static final boolean invertGyro = false; // Always ensure Gyro is CCW+ CW-

        /* Drivetrain Constants */
        public static final double trackWidth = Units.inchesToMeters(13.375);
        public static final double wheelBase = Units.inchesToMeters(25.5);
        public static final double wheelDiameter = Units.inchesToMeters(4);
        public static final double wheelCircumference = wheelDiameter * Math.PI;

        public static final double openLoopRamp = 0.25;
        public static final double closedLoopRamp = 0.0;

        public static final double driveGearRatio = 1 / 7.8; //1:7.8
        public static final double angleGearRatio =  10.28; //1:10.28

        public static final SwerveDriveKinematics swerveKinematics = new SwerveDriveKinematics(
                new Translation2d(wheelBase / 2.0, trackWidth / 2.0),
                new Translation2d(wheelBase / 2.0, -trackWidth / 2.0),
                new Translation2d(-wheelBase / 2.0, trackWidth / 2.0),
                new Translation2d(-wheelBase / 2.0, -trackWidth / 2.0));

        /* Swerve Current Limiting */
        public static final int angleContinuousCurrentLimit = 25;
        public static final int anglePeakCurrentLimit = 40;
        public static final double anglePeakCurrentDuration = 0.1;
        public static final boolean angleEnableCurrentLimit = true;

        public static final int driveContinuousCurrentLimit = 35;
        public static final int drivePeakCurrentLimit = 60;
        public static final double drivePeakCurrentDuration = 0.1;
        public static final boolean driveEnableCurrentLimit = true;

        /* Angle Motor PID Values */
        public static final double angleKP = .6;
        public static final double angleKI = 0.0;
        public static final double angleKD = 12.0;
        public static final double angleKF = 0.0;
        /* Drive Motor PID Values */
        public static final double driveKP = 0;//0.14584;
        public static final double driveKI = 0.0;
        public static final double driveKD = 0.0;
        public static final double driveKF = 0.0;

        /* Drive Motor Characterization Values */
        public static final double driveKS = (0.767 / 12); //divide by 12 to convert from volts to percent output for CTRE
        public static final double driveKV = (0.0912 / 12);
        public static final double driveKA = (0.0461 / 12);

        /* Swerve Profiling Values */ 
        public static final double maxSpeed = .01;//2.25, og 4.5; //meters per second
        public static final double maxAngularVelocity = .01;//11.5;

        /* Neutral Modes */
        public static final NeutralMode angleNeutralMode = NeutralMode.Coast;
        public static final NeutralMode driveNeutralMode = NeutralMode.Brake;

        /* Motor Inverts */
        public static final boolean driveMotorInvert = false;
        public static final boolean angleMotorInvert = false;

        /* Angle Encoder Invert */
        public static final boolean canCoderInvert = false;

        /* Module Specific Constants */
        /* Front Left Module - Module 0 */
        public static final class Mod1 {
            public static final int driveMotorID = 2;
            public static final int angleMotorID = 7;
            public static final int canCoderID = 12;
            public static final double angleOffset = 31.64062;//34.453125; //138.691; //0.543029198911517*180/Math.PI;//0.543029198911517
            public static final boolean driveInverted = false;
            public static final SwerveModuleConstants constants = 
                new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset, driveInverted);
        }

        /* Front Right Module - Module 1 */
        public static final class Mod0 {
            public static final int driveMotorID = 8;
            public static final int angleMotorID = 5;
            public static final int canCoderID = 11;
            public static final double angleOffset = 44.560546875;//225.17578125; //3.977903431774901 * 180/Math.PI;
            public static final boolean driveInverted = false;//true;
            public static final SwerveModuleConstants constants = 
                new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset, driveInverted);
        }
        
        /* Back Left Module - Module 2 */
        public static final class Mod3 {
            public static final int driveMotorID = 6;
            public static final int angleMotorID = 4;
            public static final int canCoderID = 10;
            public static final double angleOffset =249.52148437499997;//254.79492187500003 ; //273.515625; //1.244058418975255*180/Math.PI;
            public static final boolean driveInverted = false;
            public static final SwerveModuleConstants constants = 
                new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset, driveInverted);
        }

        /* Back Right Module - Module 3 q */
        //ERROR  -200 CTR: No new response to update signal Talon FX 3 ConfigSelectedFeedbackSensor

        public static final class Mod2 {
            public static final int driveMotorID = 3;
            public static final int angleMotorID = 1;
            public static final int canCoderID = 9;
            public static final double angleOffset =201.533203125  ; //94.921875; //3.486738330864062*180/Math.PI;
            public static final boolean driveInverted = false;//true; 
            public static final SwerveModuleConstants constants = 
                new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset, driveInverted);
        }

    }

    public static final class AutoConstants {
        public static final double kMaxSpeedMetersPerSecond = 1.5;
        public static final double kMaxAccelerationMetersPerSecondSquared = .5 ;
        public static final double kMaxAngularSpeedRadiansPerSecond =.05;
        public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI/4;
    
        public static final double kPXController = 0;
        public static final double kPYController = 0;
        public static final double kPThetaController = 0;
    
        // Constraint for the motion profilied robot angle controller
        public static final TrapezoidProfile.Constraints kThetaControllerConstraints =
            new TrapezoidProfile.Constraints(
                kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);
      }

}
