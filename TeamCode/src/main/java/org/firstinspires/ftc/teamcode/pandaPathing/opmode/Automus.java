package org.firstinspires.ftc.teamcode.pandaPathing.opmode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.pandaPathing.follower.Follower;
import org.firstinspires.ftc.teamcode.pandaPathing.localization.Pose;
import org.firstinspires.ftc.teamcode.pandaPathing.pathGeneration.BezierCurve;
import org.firstinspires.ftc.teamcode.pandaPathing.pathGeneration.BezierLine;
import org.firstinspires.ftc.teamcode.pandaPathing.pathGeneration.Path;
import org.firstinspires.ftc.teamcode.pandaPathing.pathGeneration.Point;

@Autonomous (name = "Automus")
public class Automus extends LinearOpMode {
    private Follower follower;

    @Override
    public void runOpMode() throws InterruptedException {
        follower = new Follower(hardwareMap);
        follower.initialize();
        for (DcMotorEx motor : follower.driveMotors)
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();
        Point startPos = new Point(new Pose(0, 0, 0));
        Point endPos = new Point(new Pose(0, 20, 0));
        Path path1 = new Path(new BezierLine(startPos, endPos));
        follower.followPath(path1);
    }
}
