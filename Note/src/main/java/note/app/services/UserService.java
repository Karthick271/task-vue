package note.app.services;

import java.util.List;

import notes.app.model.NoteModel;
import notes.app.model.UserModel;

public interface UserService {
	
	public void userRegistration(UserModel userData);
	
	public void userLogin(UserModel loginData);
	
	public void saveNotes(NoteModel data);

	public void updateNote(int id);

	public void deleteNote(int id);
	
	public List<NoteModel> getAllNotes();
	
}
 