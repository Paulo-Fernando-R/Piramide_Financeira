-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema piramide5_tp2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema piramide5_tp2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `piramide5_tp2` DEFAULT CHARACTER SET utf8 ;
USE `piramide5_tp2` ;

-- -----------------------------------------------------
-- Table `piramide5_tp2`.`local`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `piramide5_tp2`.`local` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Cidade` VARCHAR(45) NOT NULL,
  `Estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `piramide5_tp2`.`marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `piramide5_tp2`.`marca` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  `Tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `piramide5_tp2`.`esquema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `piramide5_tp2`.`esquema` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  `Lucro` DECIMAL(10,2) NOT NULL,
  `LocalId` INT NOT NULL,
  `MarcaId` INT NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_esquema_local1_idx` (`LocalId` ASC) VISIBLE,
  INDEX `fk_esquema_marca1_idx` (`MarcaId` ASC) VISIBLE,
  CONSTRAINT `fk_esquema_local1`
    FOREIGN KEY (`LocalId`)
    REFERENCES `piramide5_tp2`.`local` (`Id`),
  CONSTRAINT `fk_esquema_marca1`
    FOREIGN KEY (`MarcaId`)
    REFERENCES `piramide5_tp2`.`marca` (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `piramide5_tp2`.`pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `piramide5_tp2`.`pessoa` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  `Nivel` INT NOT NULL,
  `Ganho` DECIMAL(10,2) NOT NULL,
  `CPF` VARCHAR(11) NOT NULL,
  `CaraAcima` INT NULL DEFAULT NULL,
  `LocalId` INT NOT NULL,
  `EsquemaId` INT NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `CPF_UNIQUE` (`CPF` ASC) VISIBLE,
  INDEX `fk_pessoa_pessoa1_idx` (`CaraAcima` ASC) VISIBLE,
  INDEX `fk_pessoa_local1_idx` (`LocalId` ASC) VISIBLE,
  INDEX `fk_pessoa_esquema1_idx` (`EsquemaId` ASC) VISIBLE,
  CONSTRAINT `fk_pessoa_esquema1`
    FOREIGN KEY (`EsquemaId`)
    REFERENCES `piramide5_tp2`.`esquema` (`Id`),
  CONSTRAINT `fk_pessoa_local1`
    FOREIGN KEY (`LocalId`)
    REFERENCES `piramide5_tp2`.`local` (`Id`),
  CONSTRAINT `fk_pessoa_pessoa1`
    FOREIGN KEY (`CaraAcima`)
    REFERENCES `piramide5_tp2`.`pessoa` (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `piramide5_tp2`.`dependente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `piramide5_tp2`.`dependente` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  `PessoaId` INT NOT NULL,
  `LocalId` INT NOT NULL,
  PRIMARY KEY (`Id`, `PessoaId`),
  INDEX `fk_dependente_pessoa1_idx` (`PessoaId` ASC) VISIBLE,
  INDEX `fk_dependente_local1_idx` (`LocalId` ASC) VISIBLE,
  CONSTRAINT `fk_dependente_local1`
    FOREIGN KEY (`LocalId`)
    REFERENCES `piramide5_tp2`.`local` (`Id`),
  CONSTRAINT `fk_dependente_pessoa1`
    FOREIGN KEY (`PessoaId`)
    REFERENCES `piramide5_tp2`.`pessoa` (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
