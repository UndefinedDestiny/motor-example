// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.VoltageConfigs;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;

public class MotorSubsystem extends SubsystemBase {
  public MotorSubsystem() {}
  private final TalonFX motor = new TalonFX(0);

  private final DutyCycleOut dutyCycleOut = new DutyCycleOut(0);

  private final TalonFXConfiguration motorConfig = new TalonFXConfiguration();
  private final VoltageConfigs voltageConfig = new VoltageConfigs();

  public void setVoltage(double voltage) {
    voltageConfig.PeakForwardVoltage = voltage;
    motorConfig.Voltage = voltageConfig;
    motor.getConfigurator().apply(motorConfig);
    motor.setVoltage(voltage);
  }

  public void move(double output) {
    dutyCycleOut.Output = output;
    motor.setControl(dutyCycleOut);
  }

  @Override
  public void periodic() {}
}
