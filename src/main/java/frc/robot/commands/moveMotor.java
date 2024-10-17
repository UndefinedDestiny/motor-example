// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.MotorSubsystem;

public class moveMotor extends Command {
  private final MotorSubsystem motorSubsystem = new MotorSubsystem();
  public moveMotor() {
    addRequirements(motorSubsystem);
  }

  @Override
  public void initialize() {
    motorSubsystem.move(1.0);
    motorSubsystem.setVoltage(5.0);
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {
    motorSubsystem.setVoltage(0.0);
    motorSubsystem.move(0.0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
