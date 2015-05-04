SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

USE `icr_spring` ;

-- -----------------------------------------------------
-- Table `icr_spring`.`abstract_person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `icr_spring`.`abstract_person` (
  `id` INT NOT NULL,
  `address_id` INT NULL,
  `created` DATETIME NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `middle_name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `address_id_fk`
    FOREIGN KEY (`address_id`)
    REFERENCES `icr_spring`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `icr_spring`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `icr_spring`.`user` (
  `id` INT NOT NULL,
  `login` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `role_id` INT NULL COMMENT 'foreign key referencing users_roles table',
  PRIMARY KEY (`id`),
  CONSTRAINT `user_abs_per_id_fk`
    FOREIGN KEY (`id`)
    REFERENCES `icr_spring`.`abstract_person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `icr_spring`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `icr_spring`.`role` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `icr_spring`.`users_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `icr_spring`.`users_roles` (
  `user_id` INT NOT NULL,
  `title` VARCHAR(45) NULL,
  `role_id` INT NULL,
  PRIMARY KEY (`user_id`),
  INDEX `role_id_idx` (`role_id` ASC),
  CONSTRAINT `user_role_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `icr_spring`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `role_user_id_fk`
    FOREIGN KEY (`role_id`)
    REFERENCES `icr_spring`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `icr_spring`.`region`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `icr_spring`.`region` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `within_region` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `within_region_idx` (`within_region` ASC),
  CONSTRAINT `within_region_fk`
    FOREIGN KEY (`within_region`)
    REFERENCES `icr_spring`.`region` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `icr_spring`.`hospital`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `icr_spring`.`hospital` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `region_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `region_idx` (`region_id` ASC),
  CONSTRAINT `hosp_region_fk`
    FOREIGN KEY (`region_id`)
    REFERENCES `icr_spring`.`region` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `icr_spring`.`evaluator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `icr_spring`.`evaluator` (
  `id` INT NOT NULL,
  `title` VARCHAR(45) NULL,
  `hospital_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `hospital_id_idx` (`hospital_id` ASC),
  CONSTRAINT `eval_hospital_id_fk`
    FOREIGN KEY (`hospital_id`)
    REFERENCES `icr_spring`.`hospital` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `eval_abs_per_id_fk`
    FOREIGN KEY (`id`)
    REFERENCES `icr_spring`.`abstract_person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `icr_spring`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `icr_spring`.`patient` (
  `id` INT NOT NULL,
  `diagnosis` VARCHAR(45) NULL,
  `diagnosis_comment` LONGTEXT NULL,
  `evaluator_id` INT NULL,
  `hospital_id` INT NULL,
  `user_id` INT NULL,
  `feet_affected` VARCHAR(45) NULL,
  `evaluation_date` DATETIME NULL,
  `dob` DATETIME NULL,
  `tribe` VARCHAR(45) NULL,
  `consent_inclusion` INT NULL,
  `consent_photos` INT NULL,
  `birth_place` INT NULL,
  `birth_complications` LONGTEXT NULL,
  `affected_relatives` INT NULL,
  `pregency_length` INT NULL,
  `pregnancy_complications` LONGTEXT NULL,
  `pregnancy_drinking` LONGTEXT NULL,
  `pregnancy_smoking` LONGTEXT NULL,
  `referral_source` LONGTEXT NULL,
  `referral_other` LONGTEXT NULL,
  `referral_doctor_name` LONGTEXT NULL,
  `referral_hospital_name` LONGTEXT NULL,
  `deformity_at_birth` LONGTEXT NULL,
  `prenatal_week` INT NULL,
  `prenatal_confirmed` LONGTEXT NULL,
  `sex` VARCHAR(45) NULL,
  `race` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `evaluator_idx` (`evaluator_id` ASC),
  INDEX `hospifilterPatientReportfilterPatientReporttal_idx` (`hospital_id` ASC),
  INDEX `user_idx` (`user_id` ASC),
  CONSTRAINT `patient_evaluator_fk`
    FOREIGN KEY (`evaluator_id`)
    REFERENCES `icr_spring`.`evaluator` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `patient_hospital_fk`
    FOREIGN KEY (`hospital_id`)
    REFERENCES `icr_spring`.`hospital` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `patient_user_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `icr_spring`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `patient_abs_per_id_fk`
    FOREIGN KEY (`id`)
    REFERENCES `icr_spring`.`abstract_person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `birth_place_address_fk`
    FOREIGN KEY (`birth_place`)
    REFERENCES `icr_spring`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `icr_spring`.`visit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `icr_spring`.`visit` (
  `id` INT NOT NULL,
  `evaluator_id` INT NULL,
  `primary_caster_left_id` INT NULL,
  `primary_caster_right_id` INT NULL,
  `patient_id` INT NULL,
  `hospital_id` INT NULL,
  `user` INT NULL,
  `is_last_visit` VARCHAR(45) NULL,
  `next_visit_date` VARCHAR(45) NULL,
  `relapse` LONGTEXT NULL,
  `complications` LONGTEXT NULL,
  `complications_description` LONGTEXT NULL,
  `complications_results` LONGTEXT NULL,
  `general_comments` LONGTEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `evaluator_idx` (`evaluator_id` ASC),
  INDEX `patient_idx` (`patient_id` ASC),
  INDEX `hospital_idx` (`hospital_id` ASC),
  INDEX `user_idx` (`user` ASC),
  CONSTRAINT `visit_evaluator_fk`
    FOREIGN KEY (`evaluator_id`)
    REFERENCES `icr_spring`.`evaluator` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `visit_patient_fk`
    FOREIGN KEY (`patient_id`)
    REFERENCES `icr_spring`.`patient` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `visit_hospital_fk`
    FOREIGN KEY (`hospital_id`)
    REFERENCES `icr_spring`.`hospital` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `visit_user_fk`
    FOREIGN KEY (`user`)
    REFERENCES `icr_spring`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `icr_spring`.`associate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `icr_spring`.`associate` (
  `id` INT NOT NULL,
  `is_affected` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `associate_abs_per_id_fk`
    FOREIGN KEY (`id`)
    REFERENCES `icr_spring`.`abstract_person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `icr_spring`.`patient_associates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `icr_spring`.`patient_associates` (
  `patient_id` INT NULL,
  `associate_id` INT NULL,
  `relationship_to_patient` VARCHAR(45) NULL,
  `is_emergency_contact` INT NULL,
  `phone1` VARCHAR(45) NULL,
  `phone2` VARCHAR(45) NULL,
  INDEX `relative_idx` (`associate_id` ASC),
  CONSTRAINT `p_assoc_patient_fk`
    FOREIGN KEY (`patient_id`)
    REFERENCES `icr_spring`.`patient` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `p_assoc_associate_fk`
    FOREIGN KEY (`associate_id`)
    REFERENCES `icr_spring`.`associate` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `icr_spring`.`user_hospital`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `icr_spring`.`user_hospital` (
  `user_id` INT NOT NULL,
  `hospital_id` INT NULL,
  PRIMARY KEY (`user_id`),
  INDEX `hospital_idx` (`hospital_id` ASC),
  CONSTRAINT `user_hosp_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `icr_spring`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `hospital_user_id_fk`
    FOREIGN KEY (`hospital_id`)
    REFERENCES `icr_spring`.`hospital` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `icr_spring`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `icr_spring`.`address` (
  `id` INT NOT NULL,
  `street` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
  )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `icr_spring`.`foot`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `icr_spring`.`foot` (
  `id` INT NOT NULL,
  `visit_id` INT NULL,
  `laterality` VARCHAR(45) NULL,
  `abductus` INT NULL,
  `cast_number` INT NULL,
  `cavus` INT NULL,
  `clb` INT NULL,
  `abduction` INT NULL,
  `dorsiflexion` INT NULL,
  `eh` INT NULL,
  `hfcs` INT NULL,
  `mfcs` INT NULL,
  `mc` INT NULL,
  `equinus` INT NULL,
  `other_details` LONGTEXT NULL,
  `pc` INT NULL,
  `re` INT NULL,
  `thc` INT NULL,
  `treatment` LONGTEXT NULL,
  `varus` INT NULL,
  `brace_compliance` VARCHAR(45) NULL,
  `brace_problems` LONGTEXT NULL,
  `brace_action` LONGTEXT NULL,
  `surgery_comment` LONGTEXT NULL,
  `surgery_other` LONGTEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `visit_id_idx` (`visit_id` ASC),
  CONSTRAINT `foot_visit_id_fk`
    FOREIGN KEY (`visit_id`)
    REFERENCES `icr_spring`.`visit` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `icr_spring`.`treatment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `icr_spring`.`treatment` (
  `id` INT NOT NULL,
  `class` VARCHAR(45) NULL COMMENT 'e.g. casting, surgery',
  `type` LONGTEXT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`class` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `icr_spring`.`patients_treatments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `icr_spring`.`patients_treatments` (
  `patient_id` INT NOT NULL,
  `treatment_id` INT NOT NULL,
  `is_previous_treatment` VARCHAR(45) NULL,
  `treatment_date` DATETIME NULL,
  PRIMARY KEY (`patient_id`),
  INDEX `treatment_id_idx` (`treatment_id` ASC),
  CONSTRAINT `pt_patient_id_fk`
    FOREIGN KEY (`patient_id`)
    REFERENCES `icr_spring`.`patient` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `pt_treatment_id_fk`
    FOREIGN KEY (`treatment_id`)
    REFERENCES `icr_spring`.`treatment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `icr_spring`.`feet_treatments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `icr_spring`.`feet_treatments` (
  `foot_id` INT NOT NULL,
  `treatment_id` INT NULL,
  `primary_performer` INT NULL,
  `comment` LONGTEXT NULL,
  `problem` LONGTEXT NULL,
  `action_taken_to_problem` LONGTEXT NULL,
  PRIMARY KEY (`foot_id`),
  INDEX `primary_performer_idx` (`primary_performer` ASC),
  CONSTRAINT `ft_foot_id_fk`
    FOREIGN KEY (`foot_id`)
    REFERENCES `icr_spring`.`foot` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ft_treatment_id_fk`
    FOREIGN KEY (`treatment_id`)
    REFERENCES `icr_spring`.`treatment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ft_primary_performer_fk`
    FOREIGN KEY (`primary_performer`)
    REFERENCES `icr_spring`.`evaluator` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `icr_spring`.`audit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `icr_spring`.`audit` (
  `id` INT NOT NULL,
  `time_transaction` DATETIME NULL,
  `table_name` VARCHAR(45) NULL,
  `table_id` INT NULL,
  `user_id` INT NULL,
  `field_field` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_idx` (`user_id` ASC),
  CONSTRAINT `audit_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `icr_spring`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
