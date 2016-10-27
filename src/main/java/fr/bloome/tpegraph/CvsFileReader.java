package fr.bloome.tpegraph;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CvsFileReader implements CvsFile {

	public final char SEPARATOR = ',';
	private File file;
	private List<String> lines;
	private List<String[]> data;

	public CvsFileReader(File file) {
		this.file = file;

		init();
	}

	private void init() {
		lines = CsvFileHelper.readFile(file);

		data = new ArrayList<String[]>(lines.size());
		String sep = new Character(SEPARATOR).toString();
		for (String line : lines) {
			String[] oneData = line.split(sep);
			data.add(oneData);
		}
	}

	@Override
	public File getFile() {
		// TODO Auto-generated method stub
		return this.file;
	}

	@Override
	public List<String[]> getData() {
		// TODO Auto-generated method stub
		return this.data;
	}

}
