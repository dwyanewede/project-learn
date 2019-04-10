package com.learn.demo.design.spring.pattern.behavior.command;

// Concrete Command
public class WriteFileCommand implements Command {

	private FileSystemReceiver fileSystem;
	
	public WriteFileCommand(FileSystemReceiver fs) {
		this.fileSystem = fs;
	}
	
	@Override
	public void execute() {
		this.fileSystem.writeFile();
	}

}
