defmodule NameBadge do
  def print(id, name, department) when name != nil and department != nil do
    if id,
      do: "[#{id}] - #{name} - #{String.upcase(department)}",
      else: "#{name} - #{String.upcase(department)}"
  end

  def print(id, name, department) when id != nil and name != nil do
    if department,
      do: "[#{id}] - #{name} - #{String.upcase(department)}",
      else: "[#{id}] - #{name} - OWNER"
  end

  def print(_id, name, _department) when name != nil do
    "#{name} - OWNER"
  end
end
