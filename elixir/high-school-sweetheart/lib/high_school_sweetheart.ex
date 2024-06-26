defmodule HighSchoolSweetheart do
  def first_letter(name) do
    name
    |> String.trim()
    |> String.first()
  end

  def initial(name) do
    name 
    |> String.upcase()
    |> first_letter()
    |> Kernel.<>(".")
  end

  def initials(full_name) do
    [first_name, last_name] = String.split(full_name, " ")
    initial(first_name) <> " " <> initial(last_name)
  end

  def pair(full_name1, full_name2) do
    [initials1, initials2] = [initials(full_name1), initials(full_name2)]
    """
         ******       ******
       **      **   **      **
     **         ** **         **
    **            *            **
    **                         **
    **     X. X.  +  Y. Y.     **
     **                       **
       **                   **
         **               **
           **           **
             **       **
               **   **
                 ***
                  *
    """
    |> String.replace("X. X.", initials1)
    |> String.replace("Y. Y.", initials2)
  end
end
