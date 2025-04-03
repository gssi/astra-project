package it.gssi.astra.metaeditor.common.interfaces;

import java.io.File;
import java.util.List;

import javafx.concurrent.Task;

public interface IFileManager {

	public boolean create(List<String> paths);
	public void loadFolder();
	public void loadSelection();
	public void loadFiles(List<File> files);
	public void loadFilesRecursive(int index, List<File> files);
	public Task<Void> load(List<String> paths);
	public void save();
	public void saveAs(List<String> paths);
	public void saveAll();
}
