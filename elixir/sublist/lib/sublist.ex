defmodule Sublist do
  @doc """
  Returns whether the first list is a sublist or a superlist of the second list
  and if not whether it is equal or unequal to the second list.
  """
  def compare(a, a) do
    :equal
  end

  def compare(a, b) do
    case List.myers_difference(a, b) do
      [{:eq, elements}] when elements == b -> :eq
      [{:ins, elements}] -> :sublist
      [{:del, elements}] -> :del
    end
  end
end
