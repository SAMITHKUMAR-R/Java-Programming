package programs;

/*
Create an abstract class Content with abstract methods publish(), edit(), and concrete method 
getContentInfo(). Define interfaces Commentable and Shareable. Implement BlogPost, VideoPost, 
and ImagePost extending the abstract class and interfaces. Write CMS logic that manages content 
polymorphically and supports comments and shares. 
 */

//Abstract class 
abstract class Content { 
	String title; 

	Content(String title) { 
		this.title = title; 
	} 

	abstract void publish(); 
	abstract void edit(); 

	void getContentInfo() { 
		System.out.println("Content Title: " + title); 
	} 
} 

//Interface for comments 
interface Commentable { 
	void addComment(String comment); 
} 

//Interface for sharing 
interface Shareable { 
	void share(); 
} 

//BlogPost class 
class BlogPost extends Content implements Commentable, Shareable { 

	BlogPost(String title) { 
		super(title); 
	} 

	public void publish() { 
		System.out.println("Publishing Blog Post..."); 
	} 

	public void edit() { 
		System.out.println("Editing Blog Post..."); 
	} 

	public void addComment(String comment) { 
		System.out.println("Blog Comment Added: " + comment); 
	} 

	public void share() { 
		System.out.println("Blog Post Shared!"); 
	} 
} 

//VideoPost class 
class VideoPost extends Content implements Commentable, Shareable { 
	VideoPost(String title) { 
		super(title); 
	} 
	public void publish() { 
		System.out.println("Uploading Video..."); 
	} 
	public void edit() { 
		System.out.println("Editing Video..."); 
	} 
	public void addComment(String comment) { 
		System.out.println("Video Comment Added: " + comment); 
	} 
	public void share() { 
     System.out.println("Video Shared!"); 
	} 
} 

//ImagePost class 
class ImagePost extends Content implements Commentable, Shareable { 

	ImagePost(String title) { 
		super(title); 
	} 

	public void publish() { 
		System.out.println("Posting Image..."); 
	} 

	public void edit() { 
		System.out.println("Editing Image..."); 
	} 

	public void addComment(String comment) { 
		System.out.println("Image Comment Added: " + comment); 
	} 

	public void share() { 
		System.out.println("Image Shared!"); 
	} 
} 
public class CMSDemo { 
	public static void main(String[] args) { 
		Content[] contents = { 
				new BlogPost("Java OOP Concepts"), 
				new VideoPost("Polymorphism Tutorial"), 
				new ImagePost("Design Patterns Chart") 
		}; 
		for (Content c : contents) { 
			c.getContentInfo();   // Concrete method 
			c.publish();          // Polymorphic call 
			c.edit();             // Polymorphic call 
			// Downcasting to access interface methods 
			if (c instanceof Commentable) { 
				((Commentable) c).addComment("Great content!"); 
			} 
			if (c instanceof Shareable) { 
				((Shareable) c).share(); 
			} 
			System.out.println("----------------------------"); 
		} 
	} 
} 
