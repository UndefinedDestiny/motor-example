// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.sim.TalonFXSimState;

public class MotorSubsystem extends SubsystemBase {
  public MotorSubsystem() {}
  private final TalonFX motor = new TalonFX(0);
  private final TalonFXSimState motorSimState = new TalonFXSimState(motor);
  private final DCMotorSim motorSim = new DCMotorSim(DCMotor.getKrakenX60(1), 1.0, 0.01);

  public void setVoltage(double voltage) {
    motor.setVoltage(voltage);
  }

  @Override
  public void periodic() {

  }

  @Override
  public void simulationPeriodic() {
    motorSim.setInputVoltage(motorSimState.getMotorVoltage());
    motorSim.update(0.02);
    motorSimState.setRawRotorPosition(motorSim.getAngularPositionRotations());
    motorSimState.setRotorVelocity(motorSim.getAngularVelocityRPM() / 60);
  }
}