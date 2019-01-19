package com.cybermate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient_vitals_txn")
public class Vitals {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int vitalId;
	@Column(name="medical_record_no")
	private String medicalRecordNo;
	@Column(name="episode_id")
	private String episodeId;
	@Column(name="visit_id")
	private String visitId;
	@Column(name="weight")
	private String weight;
	@Column(name="weight_unit")
	private String weightUnit;
	@Column(name="height1")
	private String height1;
	@Column(name="height1_unit")
	private String height1Unit;
	@Column(name="height2")
	private String height2;
	@Column(name="height2_unit")
	private String height2Unit;
	@Column(name="bmi")
	private String bmi;
	@Column(name="bp_systolic")
	private String bpSystolic;
	@Column(name="bp_diastolic")
	private String bpDiastolic;
	@Column(name="temperature")
	private String temperature;
	@Column(name="pulse_rate")
	private String pulseRate;
	@Column(name="pulse_pattern")
	private String pulsePattern;
	@Column(name="pulse_volume")
	private String pulseVolume;
	@Column(name="additional_notes")
	private String additionalNotes;

	public int getVitalId() {
		return vitalId;
	}
	public void setVitalId(int vitalId) {
		this.vitalId = vitalId;
	}
	public String getMedicalRecordNo() {
		return medicalRecordNo;
	}
	public void setMedicalRecordNo(String medicalRecordNo) {
		this.medicalRecordNo = medicalRecordNo;
	}
	public String getEpisodeId() {
		return episodeId;
	}
	public void setEpisodeId(String episodeId) {
		this.episodeId = episodeId;
	}
	public String getVisitId() {
		return visitId;
	}
	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getWeightUnit() {
		return weightUnit;
	}
	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}
	public String getHeight1() {
		return height1;
	}
	public void setHeight1(String height1) {
		this.height1 = height1;
	}
	public String getHeight1Unit() {
		return height1Unit;
	}
	public void setHeight1Unit(String height1Unit) {
		this.height1Unit = height1Unit;
	}
	public String getHeight2() {
		return height2;
	}
	public void setHeight2(String height2) {
		this.height2 = height2;
	}
	public String getHeight2Unit() {
		return height2Unit;
	}
	public void setHeight2Unit(String height2Unit) {
		this.height2Unit = height2Unit;
	}
	public String getBmi() {
		return bmi;
	}
	public void setBmi(String bmi) {
		this.bmi = bmi;
	}
	public String getBpSystolic() {
		return bpSystolic;
	}
	public void setBpSystolic(String bpSystolic) {
		this.bpSystolic = bpSystolic;
	}
	public String getBpDiastolic() {
		return bpDiastolic;
	}
	public void setBpDiastolic(String bpDiastolic) {
		this.bpDiastolic = bpDiastolic;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getPulseRate() {
		return pulseRate;
	}
	public void setPulseRate(String pulseRate) {
		this.pulseRate = pulseRate;
	}
	public String getPulsePattern() {
		return pulsePattern;
	}
	public void setPulsePattern(String pulsePattern) {
		this.pulsePattern = pulsePattern;
	}
	public String getPulseVolume() {
		return pulseVolume;
	}
	public void setPulseVolume(String pulseVolume) {
		this.pulseVolume = pulseVolume;
	}
	public String getAdditionalNotes() {
		return additionalNotes;
	}
	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}
	
}
